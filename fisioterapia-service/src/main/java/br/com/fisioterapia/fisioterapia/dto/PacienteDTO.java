package br.com.fisioterapia.fisioterapia.dto;

import java.io.Serializable;
import java.util.List;

public class PacienteDTO extends FisioterapiaDTO implements Serializable {

	/**
	 *  serialVersionUID.
	 */
	private static final long serialVersionUID = -3483384980561085014L;
	
	private Long id;
	private String nome;
	private Integer idade;
	private String estadoCivil;
	private String sexo;
	private String ocupacao;
	private String telefone;
	private String cpf;
	private transient List<EnderecoDTO> listaEnderecoDTO;
	private Boolean ativo = Boolean.TRUE;

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
	 * @return the idade
	 */
	public Integer getIdade() {
		return idade;
	}
	/**
	 * @param idade the idade to set
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	/**
	 * @return the estadoCivil
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}
	/**
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the ocupacao
	 */
	public String getOcupacao() {
		return ocupacao;
	}
	/**
	 * @param ocupacao the ocupacao to set
	 */
	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the listaEnderecoDTO
	 */
	public List<EnderecoDTO> getListaEnderecoDTO() {
		return listaEnderecoDTO;
	}
	/**
	 * @param listaEnderecoDTO the listaEnderecoDTO to set
	 */
	public void setListaEnderecoDTO(List<EnderecoDTO> listaEnderecoDTO) {
		this.listaEnderecoDTO = listaEnderecoDTO;
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
