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
@Table(name = "ponto")
public class Ponto extends Fisioterapia {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -8826497043754879223L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "avaliacao_id", referencedColumnName = "id")
	private Avaliacao avaliacao;
	
	@Column(name = "screenX")
	private Integer screenX;
	
	@Column(name = "screenY")
	private Integer screenY;

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
	 * @return the avaliacao
	 */
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	/**
	 * @param avaliacao the avaliacao to set
	 */
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	/**
	 * @return the screenX
	 */
	public Integer getScreenX() {
		return screenX;
	}

	/**
	 * @param screenX the screenX to set
	 */
	public void setScreenX(Integer screenX) {
		this.screenX = screenX;
	}

	/**
	 * @return the screenY
	 */
	public Integer getScreenY() {
		return screenY;
	}

	/**
	 * @param screenY the screenY to set
	 */
	public void setScreenY(Integer screenY) {
		this.screenY = screenY;
	}
	
}