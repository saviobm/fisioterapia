package br.com.fisioterapia.fisioterapia.dto;

import java.io.Serializable;

public class EstadoDTO extends FisioterapiaDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2708685866133271327L;
	
	private Long id;
	private String sgEstado;
	private String nome;
	
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
	 * @return the sgEstado
	 */
	public String getSgEstado() {
		return sgEstado;
	}
	/**
	 * @param sgEstado the sgEstado to set
	 */
	public void setSgEstado(String sgEstado) {
		this.sgEstado = sgEstado;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
