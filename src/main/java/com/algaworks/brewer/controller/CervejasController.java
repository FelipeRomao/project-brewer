package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@PostMapping(value = "/cervejas/novo")
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			model.addAttribute("mensagem", "Erro ao tentar salvar o cadastro");
			return "cerveja/CadastroCerveja";
		}
		
		attributes.addFlashAttribute("mensagem", "Cadastro salvo com sucesso!");
		return "redirect:/cervejas/novo";
	}
}
