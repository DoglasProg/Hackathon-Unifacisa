package com.hackaton.unifacisa.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackaton.unifacisa.domain.Refeicao;

public class RefeicaoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private int quantidade;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private Integer tipoRefeicao;
	
	public RefeicaoDTO() {}
	
	public RefeicaoDTO(Refeicao refeicao) {
		this.id= refeicao.getId();
		this.data= refeicao.getData();
		this.tipoRefeicao = refeicao.getTipoRefeicao().getCod();
		this.quantidade = refeicao.getQuantidade();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getTipoRefeicao() {
		return tipoRefeicao;
	}

	public void setTipoRefeicao(Integer tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}
	
}
