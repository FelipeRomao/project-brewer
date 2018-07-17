package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.algaworks.brewer.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@PostMapping(value = "/cervejas/novo")
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Ocorreu um erro sim!");
		}
		
		System.out.println(">>>>> sku : " + cerveja.getSku());
		return "cerveja/CadastroCerveja";
	}
}
