package br.com.fisioterapia.fisioterapia.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado extends Fisioterapia {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 2232343754323952392L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "sg_estado")
	private String sgEstado;
	
	@Column(name = "ds_nome")
	private String nome;
	
	@OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
	private List<Cidade> listaCidade;

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

	/**
	 * @return the listaCidade
	 */
	public List<Cidade> getListaCidade() {
		return listaCidade;
	}

	/**
	 * @param listaCidade the listaCidade to set
	 */
	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}
	
}
