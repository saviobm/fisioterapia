package br.com.fisioterapia.fisioterapia.dto;

import java.io.Serializable;

public class EnumDTO implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -4542775073856810639L;
	
	private Integer id;
	
	private String sigla;
	
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
