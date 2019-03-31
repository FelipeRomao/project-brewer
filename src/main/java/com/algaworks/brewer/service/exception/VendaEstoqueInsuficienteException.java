package com.algaworks.brewer.service.exception;

public class VendaEstoqueInsuficienteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VendaEstoqueInsuficienteException(String message) {
		super(message);
	}
	
	public VendaEstoqueInsuficienteException(String message, Throwable cause) {
		super(message, cause);
	}

}
