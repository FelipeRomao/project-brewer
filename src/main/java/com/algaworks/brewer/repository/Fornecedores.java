package com.algaworks.brewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.brewer.model.Fornecedor;
import com.algaworks.brewer.repository.helper.fornecedor.FornecedoresQueries;

public interface Fornecedores extends JpaRepository<Fornecedor, Long>, FornecedoresQueries {
	
	public List<Fornecedor> findByRazaoSocialStartingWithIgnoreCase(String razaoSocial);
	
	Optional<Fornecedor> findByCnpj(String cnpj);

}
