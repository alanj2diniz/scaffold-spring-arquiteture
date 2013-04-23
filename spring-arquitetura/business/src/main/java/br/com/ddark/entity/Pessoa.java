package br.com.ddark.entity;

import javax.persistence.Column;

public class Pessoa extends AbstractDefaultEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 14)
	private String cpfCnpj;
	
	@Column(nullable = false, length = 70)
	private String nome;
	
	@Column(nullable = false, length = 50)
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
