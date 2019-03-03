package com.algaworks.brewer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.controller.page.PageWrapper;
import com.algaworks.brewer.model.Fornecedor;
import com.algaworks.brewer.repository.Estados;
import com.algaworks.brewer.repository.Fornecedores;
import com.algaworks.brewer.repository.filter.FornecedorFilter;
import com.algaworks.brewer.service.CadastroFornecedorService;
import com.algaworks.brewer.service.exception.CnpjFornecedorJaCadastradoException;

@Controller
@RequestMapping("/fornecedores")
public class FornecedoresController {

	@Autowired
	private Fornecedores fornecedores;

	@Autowired
	private Estados estados;

	@Autowired
	private CadastroFornecedorService cadastroFornecedorService;

	@GetMapping("/novo")
	public ModelAndView novo(Fornecedor fornecedor) {
		ModelAndView mv = new ModelAndView("fornecedor/CadastroFornecedor");
		mv.addObject("fornecedores", fornecedores.findAll());
		mv.addObject("estados", estados.findAll());

		return mv;
	}

	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Fornecedor fornecedor, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(fornecedor);
		}

		try {
			cadastroFornecedorService.salvar(fornecedor);
		} catch (CnpjFornecedorJaCadastradoException e) {
			result.rejectValue("cnpj", e.getMessage(), e.getMessage());
			return novo(fornecedor);
		}

		attributes.addFlashAttribute("mensagem", "Fornecedor salvo com sucesso");
		return new ModelAndView("redirect:/fornecedores/novo");
	}

	@GetMapping
	public ModelAndView pesquisar(FornecedorFilter filtro, BindingResult result
			,@PageableDefault(size = 3) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("fornecedor/PesquisaFornecedores");

		PageWrapper<Fornecedor> paginaWrapper = new PageWrapper<>(fornecedores.filtrar(filtro, pageable), httpServletRequest);
		mv.addObject("pagina", paginaWrapper);

		return mv;
	}

	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo) {
		Fornecedor fornecedor = fornecedores.buscarCidadeEstado(codigo);
		ModelAndView mv = novo(fornecedor);
		mv.addObject(fornecedor);

		return mv;
	}

	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Fornecedor fornecedor) {
		cadastroFornecedorService.excluir(fornecedor);

		return ResponseEntity.ok().build();
	}
}
