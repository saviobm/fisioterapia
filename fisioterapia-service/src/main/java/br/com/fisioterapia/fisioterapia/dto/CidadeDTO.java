package br.com.fisioterapia.fisioterapia.dto;

import java.io.Serializable;

public class CidadeDTO extends FisioterapiaDTO implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3085775681069510675L;
	
	private Long id;
	private String nome;
	private transient EstadoDTO estado;
	
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
	/**
	 * @return the estado
	 */
	public EstadoDTO getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	
}
