package br.com.ddark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddark.entity.Pessoa;
import br.com.ddark.repository.PessoaRepository;

@Service
public class PessoaService implements IPessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public void save(Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
	}

	public List<Pessoa> findAll() {
		return this.pessoaRepository.findAll();
	}
}
