package br.com.fisioterapia.fisioterapia.dto;

import java.io.Serializable;

public class EnderecoDTO extends FisioterapiaDTO implements Serializable {
	
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 2052013789468706380L;

	private Long id;
	private String descricaoEndereco;
	private String cep;
	private String complemento;
	private transient CidadeDTO cidade;
	private Boolean ativo;
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
	 * @return the descricaoEndereco
	 */
	public String getDescricaoEndereco() {
		return descricaoEndereco;
	}
	/**
	 * @param descricaoEndereco the descricaoEndereco to set
	 */
	public void setDescricaoEndereco(String descricaoEndereco) {
		this.descricaoEndereco = descricaoEndereco;
	}
	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}
	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	/**
	 * @return the cidade
	 */
	public CidadeDTO getCidade() {
		return cidade;
	}
	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}
	/**
	 * @return the ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}
	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
}
