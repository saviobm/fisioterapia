package br.com.fisioterapia.fisioterapia.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacao")
public class Avaliacao extends Fisioterapia {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 4211143835170238157L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "data_avaliacao")
	private Date dataAvaliacao;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "paciente_id", referencedColumnName = "id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "patologia_id", referencedColumnName = "id")
	private Patologia patologia;
	
	@Column(name = "cid")
	private String cid;
	
	@Column(name = "desc_ocupacao")
	private String descricaoOcupacao;
	
	@Column(name = "desc_uso_medicamentos")
	private String descricaoUsoMedicamentos;
	
	@Column(name = "desc_princ_queixas")
	private String descricaoPrincipaisQueixas;
	
	@Column(name = "hma")
	private String descricaoHMA;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "mini_mental_id", referencedColumnName = "id")
	private MiniMental miniMental;
	
	@Column(name = "desc_aspecto_secrecao")
	private String descricaoAspectoSecrecao;

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
	 * @return the dataAvaliacao
	 */
	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	/**
	 * @param dataAvaliacao the dataAvaliacao to set
	 */
	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return the patologia
	 */
	public Patologia getPatologia() {
		return patologia;
	}

	/**
	 * @param patologia the patologia to set
	 */
	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * @return the descricaoOcupacao
	 */
	public String getDescricaoOcupacao() {
		return descricaoOcupacao;
	}

	/**
	 * @param descricaoOcupacao the descricaoOcupacao to set
	 */
	public void setDescricaoOcupacao(String descricaoOcupacao) {
		this.descricaoOcupacao = descricaoOcupacao;
	}

	/**
	 * @return the descricaoUsoMedicamentos
	 */
	public String getDescricaoUsoMedicamentos() {
		return descricaoUsoMedicamentos;
	}

	/**
	 * @param descricaoUsoMedicamentos the descricaoUsoMedicamentos to set
	 */
	public void setDescricaoUsoMedicamentos(String descricaoUsoMedicamentos) {
		this.descricaoUsoMedicamentos = descricaoUsoMedicamentos;
	}

	/**
	 * @return the descricaoPrincipaisQueixas
	 */
	public String getDescricaoPrincipaisQueixas() {
		return descricaoPrincipaisQueixas;
	}

	/**
	 * @param descricaoPrincipaisQueixas the descricaoPrincipaisQueixas to set
	 */
	public void setDescricaoPrincipaisQueixas(String descricaoPrincipaisQueixas) {
		this.descricaoPrincipaisQueixas = descricaoPrincipaisQueixas;
	}

	/**
	 * @return the descricaoHMA
	 */
	public String getDescricaoHMA() {
		return descricaoHMA;
	}

	/**
	 * @param descricaoHMA the descricaoHMA to set
	 */
	public void setDescricaoHMA(String descricaoHMA) {
		this.descricaoHMA = descricaoHMA;
	}

	/**
	 * @return the miniMental
	 */
	public MiniMental getMiniMental() {
		return miniMental;
	}

	/**
	 * @param miniMental the miniMental to set
	 */
	public void setMiniMental(MiniMental miniMental) {
		this.miniMental = miniMental;
	}

	/**
	 * @return the descricaoAspectoSecrecao
	 */
	public String getDescricaoAspectoSecrecao() {
		return descricaoAspectoSecrecao;
	}

	/**
	 * @param descricaoAspectoSecrecao the descricaoAspectoSecrecao to set
	 */
	public void setDescricaoAspectoSecrecao(String descricaoAspectoSecrecao) {
		this.descricaoAspectoSecrecao = descricaoAspectoSecrecao;
	}

}
	