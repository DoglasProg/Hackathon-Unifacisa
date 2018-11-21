package com.hackaton.unifacisa.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.hackaton.unifacisa.domain.Refeicao;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento Obrigatorio")
	private String nome;
	
	private String telefone;
	
	@Email
	@NotEmpty(message="Preenchimento Obrigatorio")
	private String email;
	
	@NotEmpty(message="Preenchimento Obrigatorio")
	private String senha;
	
	@NotEmpty(message="Preenchimento Obrigatorio")
	private int idade;
	
	@NotEmpty(message="Preenchimento Obrigatorio")
	private double altura;
	
	@NotEmpty(message="Preenchimento Obrigatorio")
	private double peso;
	
	private List<Refeicao> refeiccoes;
	
	
	private UsuarioDTO() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public List<Refeicao> getRefeiccoes() {
		return refeiccoes;
	}

	public void setRefeiccoes(List<Refeicao> refeiccoes) {
		this.refeiccoes = refeiccoes;
	}

}
