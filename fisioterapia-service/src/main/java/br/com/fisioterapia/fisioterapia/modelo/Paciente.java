package br.com.fisioterapia.fisioterapia.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente extends Fisioterapia {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5633401326111459520L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "ds_nome", length = 200, nullable = false)
	private String nome;
	
	@Column(name = "sg_estado_civil", length = 3, nullable = false)
	private String estadoCivil;
	
	@Column(name = "sg_sexo", length = 1, nullable = false)
	private String sexo;
	
	@Column(name = "ds_ocupacao", length = 200, nullable = false)
	private String ocupacao;
	
	@Column(name = "nr_telefone", length = 11, nullable = false)
	private String telefone;
	
	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "id_endereco", referencedColumnName = "id")
	private Endereco endereco;
	
	@Column(name = "in_ativo")
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
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
