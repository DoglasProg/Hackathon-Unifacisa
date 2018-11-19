package com.hackaton.unifacisa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackaton.unifacisa.domain.enums.TipoRefeicao;

@Entity
public class Refeicao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataRefeicao;
	
	private int quantidade;
	private Integer tipoRefeicao;
	
	@OneToMany
	@JoinColumn(name="alimento_id")
	private List<Alimento> alimentos = new ArrayList<>();
	
	public Refeicao() {}
	
	public Refeicao(Integer id, Date dataRefeicao, int quantidade, TipoRefeicao tipoRefeicao) {
		super();
		this.id = id;
		this.dataRefeicao = dataRefeicao;
		this.quantidade = quantidade;
		this.tipoRefeicao = tipoRefeicao.getCod();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(Alimento alimentos) {
		this.alimentos.add(alimentos);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public TipoRefeicao getTipoRefeicao() {
		return TipoRefeicao.toEnum(this.tipoRefeicao);
	}

	public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao.getCod();
	}

	public Date getDataRefeicao() {
		return dataRefeicao;
	}

	public void setDataRefeicao(Date dataRefeicao) {
		this.dataRefeicao = dataRefeicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refeicao other = (Refeicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
