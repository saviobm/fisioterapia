package br.com.fisioterapia.fisioterapia.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade extends Fisioterapia {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 341632957971035811L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ds_nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "id_estado", referencedColumnName = "id")
	private Estado estado;
	
	@OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
	private List<Endereco> listaEndereco;

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
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * @return the listaEndereco
	 */
	public List<Endereco> getListaEndereco() {
		return listaEndereco;
	}

	/**
	 * @param listaEndereco the listaEndereco to set
	 */
	public void setListaEndereco(List<Endereco> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}
	
}
