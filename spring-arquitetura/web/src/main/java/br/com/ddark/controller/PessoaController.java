package br.com.ddark.controller;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.ddark.entity.Pessoa;
import br.com.ddark.service.PessoaService;

@Controller("pessoaController")
@RequestScoped
public class PessoaController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;
	
	@Autowired
	private PessoaService pessoaService;
	
	public PessoaController() {
		this.pessoa = new Pessoa();
	}
	
	public void createPessoa() {
		this.pessoa.setCpfCnpj("1231321");
		this.pessoa.setEmail("teste@teste.com.br");
		this.pessoa.setNome("Teste");
		
		this.pessoaService.save(pessoa);
	}

}
