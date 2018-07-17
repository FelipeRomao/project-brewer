package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@PostMapping(value = "/cervejas/novo")
	public String cadastrar(String sku) {
		System.out.println(">>>>> sku : " + sku);
		
		return "cerveja/CadastroCerveja";
	}
}
