package br.com.fisioterapia.fisioterapia.dto;

import java.util.List;

public class AshworthDTO extends FisioterapiaDTO {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -3531499899923317633L;
	
	private String descricao;
	private Boolean selecionado;
	private String descricaoColuna;
	private List<AshworthDTO> lista;
	
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
	/**
	 * @return the descricaoColuna
	 */
	public String getDescricaoColuna() {
		return descricaoColuna;
	}
	/**
	 * @param descricaoColuna the descricaoColuna to set
	 */
	public void setDescricaoColuna(String descricaoColuna) {
		this.descricaoColuna = descricaoColuna;
	}
	/**
	 * @return the lista
	 */
	public List<AshworthDTO> getLista() {
		return lista;
	}
	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<AshworthDTO> lista) {
		this.lista = lista;
	}
	
}