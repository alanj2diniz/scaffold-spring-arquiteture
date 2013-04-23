package br.com.ddark.service;

import java.util.List;

import br.com.ddark.entity.Pessoa;

public interface IPessoaService {
	
	void save(Pessoa pessoa);
	
	List<Pessoa> findAll();
	
}
