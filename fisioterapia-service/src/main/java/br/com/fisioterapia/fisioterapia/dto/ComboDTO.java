package br.com.fisioterapia.fisioterapia.dto;

import java.io.Serializable;

public class ComboDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7897802727091815440L;
	
	private Long id;
	private String sigla;
	private String descricao;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}
	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
