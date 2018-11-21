package com.hackaton.unifacisa.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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
	
	private int idRefeicao;
	
	private UsuarioDTO() {}
	
	
	

}
