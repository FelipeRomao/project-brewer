package com.algaworks.brewer.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.brewer.service.exception.NomeEstiloJaCadastradoException;
import com.algaworks.brewer.service.exception.VendaEstoqueInsuficienteException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(NomeEstiloJaCadastradoException.class)
	public ResponseEntity<String> handleNomeEstiloJaCadastradoException(NomeEstiloJaCadastradoException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
	@ExceptionHandler(VendaEstoqueInsuficienteException.class)
	public ResponseEntity<String> handleVendaEstoqueInsuficienteException(VendaEstoqueInsuficienteException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
