package com.algaworks.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Fornecedor;
import com.algaworks.brewer.repository.Fornecedores;
import com.algaworks.brewer.service.exception.CnpjFornecedorJaCadastradoException;

@Service
public class CadastroFornecedorService {

	@Autowired
	private Fornecedores fornecedores;

	@Transactional
	public void salvar(Fornecedor fornecedor) {
		Optional<Fornecedor> fornecedorExistente = fornecedores.findByCnpj(fornecedor.getCnpj());
		if (fornecedorExistente.isPresent() && !fornecedorExistente.get().equals(fornecedor)) {
			throw new CnpjFornecedorJaCadastradoException("CNPJ já cadastrado");
		}
		
		fornecedores.save(fornecedor);
	}

	@Transactional
	public void excluir(Fornecedor fornecedor) {
		fornecedores.delete(fornecedor);
	}
}
