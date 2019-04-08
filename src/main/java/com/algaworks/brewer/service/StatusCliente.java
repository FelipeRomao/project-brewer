package com.algaworks.brewer.service;

import com.algaworks.brewer.repository.Clientes;

public enum StatusCliente {

	ATIVAR {
		@Override
		public void executar(Long[] codigos, Clientes clientes) {
			clientes.findByCodigoIn(codigos).forEach(c -> c.setAtivo(true));	
		}
	},
	DESATIVAR {
		@Override
		public void executar(Long[] codigos, Clientes clientes) {
			clientes.findByCodigoIn(codigos).forEach(c -> c.setAtivo(false));
		}
	};

	public abstract void executar(Long[] codigos, Clientes clientes);
}
