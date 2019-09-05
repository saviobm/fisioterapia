package br.com.fisioterapia.fisioterapia.dto;

import java.util.List;

public class CkDTO extends FisioterapiaDTO {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9180336853190198395L;
	
	private String titulo;  
	private List<String> sigla;  
	private List<String> descricao;
	private Boolean selecionado;
	
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
	 * @return the sigla
	 */
	public List<String> getSigla() {
		return sigla;
	}
	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(List<String> sigla) {
		this.sigla = sigla;
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
	 * @return the selecionado
	 */
	public Boolean getSelecionado() {
		return selecionado;
	}
	/**
	 * @param selecionado the selecionado to set
	 */
	public void setSelecionado(Boolean selecionado) {
		this.selecionado = selecionado;
	}
	
}