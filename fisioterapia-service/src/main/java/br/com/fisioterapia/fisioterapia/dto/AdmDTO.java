package br.com.fisioterapia.fisioterapia.dto;

import java.util.List;

public class AdmDTO extends FisioterapiaDTO {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 7014724937626484555L;
	
	private String titulo;
	private List<String> descricao;
	private Boolean value;
	private List<Boolean> readOnly;
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the descricao
	 */
	public List<String> getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(List<String> descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the value
	 */
	public Boolean getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Boolean value) {
		this.value = value;
	}
	/**
	 * @return the readOnly
	 */
	public List<Boolean> getReadOnly() {
		return readOnly;
	}
	/**
	 * @param readOnly the readOnly to set
	 */
	public void setReadOnly(List<Boolean> readOnly) {
		this.readOnly = readOnly;
	}
	
}