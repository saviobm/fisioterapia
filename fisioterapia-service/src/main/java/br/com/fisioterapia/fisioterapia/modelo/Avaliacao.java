package br.com.fisioterapia.fisioterapia.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name = "desc_diag_fisioterapeutico")
	private String descricaoDiagFisioterapeutico;
	
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
	
	@Column(name = "desc_amplitude_articular")
	private String descricaoAmplitudeArticular;
	
	@Column(name = "desc_pele")
	private String   descricaoPele;
	
	@Column(name = "desc_local")
	private String descricaoLocal;
	  
	@Column(name = "desc_Tipo")
	private String descricaoTipo;
	  
	@Column(name = "desc_grau")
	private String descricaoGrau;
	  
	@Column(name = "desc_sequelas")
	private String descricaoSequelas;
	
	@Column(name = "desc_fatores_agravantes")
	private String descricaoFatoresAgravantes;
	  
	@Column(name = "desc_fatores_atenuantes")
	private String descricaoFatoresAtenuantes;
	  
	@Column(name = "desc_observacoes")
	private String descricaoObservacoes;

	@Column(name = "desc_objetivos")
	private String descricaoObjetivos;
	  
	@Column(name = "desc_condutas")
	private String descricaoCondutas;
	
	@Column(name = "desc_habitos_vicios")
	private String descricaoHabitosVicios;
	
	@OneToMany(mappedBy = "avaliacao")
	private List<Ponto> listaPontos;

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
	 * @return the descricaoDiagFisioterapeutico
	 */
	public String getDescricaoDiagFisioterapeutico() {
		return descricaoDiagFisioterapeutico;
	}

	/**
	 * @param descricaoDiagFisioterapeutico the descricaoDiagFisioterapeutico to set
	 */
	public void setDescricaoDiagFisioterapeutico(String descricaoDiagFisioterapeutico) {
		this.descricaoDiagFisioterapeutico = descricaoDiagFisioterapeutico;
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

	/**
	 * @return the descricaoAmplitudeArticular
	 */
	public String getDescricaoAmplitudeArticular() {
		return descricaoAmplitudeArticular;
	}

	/**
	 * @param descricaoAmplitudeArticular the descricaoAmplitudeArticular to set
	 */
	public void setDescricaoAmplitudeArticular(String descricaoAmplitudeArticular) {
		this.descricaoAmplitudeArticular = descricaoAmplitudeArticular;
	}

	/**
	 * @return the descricaoPele
	 */
	public String getDescricaoPele() {
		return descricaoPele;
	}

	/**
	 * @param descricaoPele the descricaoPele to set
	 */
	public void setDescricaoPele(String descricaoPele) {
		this.descricaoPele = descricaoPele;
	}

	/**
	 * @return the descricaoLocal
	 */
	public String getDescricaoLocal() {
		return descricaoLocal;
	}

	/**
	 * @param descricaoLocal the descricaoLocal to set
	 */
	public void setDescricaoLocal(String descricaoLocal) {
		this.descricaoLocal = descricaoLocal;
	}

	/**
	 * @return the descricaoTipo
	 */
	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	/**
	 * @param descricaoTipo the descricaoTipo to set
	 */
	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}

	/**
	 * @return the descricaoGrau
	 */
	public String getDescricaoGrau() {
		return descricaoGrau;
	}

	/**
	 * @param descricaoGrau the descricaoGrau to set
	 */
	public void setDescricaoGrau(String descricaoGrau) {
		this.descricaoGrau = descricaoGrau;
	}

	/**
	 * @return the descricaoSequelas
	 */
	public String getDescricaoSequelas() {
		return descricaoSequelas;
	}

	/**
	 * @param descricaoSequelas the descricaoSequelas to set
	 */
	public void setDescricaoSequelas(String descricaoSequelas) {
		this.descricaoSequelas = descricaoSequelas;
	}

	/**
	 * @return the descricaoFatoresAgravantes
	 */
	public String getDescricaoFatoresAgravantes() {
		return descricaoFatoresAgravantes;
	}

	/**
	 * @param descricaoFatoresAgravantes the descricaoFatoresAgravantes to set
	 */
	public void setDescricaoFatoresAgravantes(String descricaoFatoresAgravantes) {
		this.descricaoFatoresAgravantes = descricaoFatoresAgravantes;
	}

	/**
	 * @return the descricaoFatoresAtenuantes
	 */
	public String getDescricaoFatoresAtenuantes() {
		return descricaoFatoresAtenuantes;
	}

	/**
	 * @param descricaoFatoresAtenuantes the descricaoFatoresAtenuantes to set
	 */
	public void setDescricaoFatoresAtenuantes(String descricaoFatoresAtenuantes) {
		this.descricaoFatoresAtenuantes = descricaoFatoresAtenuantes;
	}

	/**
	 * @return the descricaoObservacoes
	 */
	public String getDescricaoObservacoes() {
		return descricaoObservacoes;
	}

	/**
	 * @param descricaoObservacoes the descricaoObservacoes to set
	 */
	public void setDescricaoObservacoes(String descricaoObservacoes) {
		this.descricaoObservacoes = descricaoObservacoes;
	}

	/**
	 * @return the descricaoObjetivos
	 */
	public String getDescricaoObjetivos() {
		return descricaoObjetivos;
	}

	/**
	 * @param descricaoObjetivos the descricaoObjetivos to set
	 */
	public void setDescricaoObjetivos(String descricaoObjetivos) {
		this.descricaoObjetivos = descricaoObjetivos;
	}

	/**
	 * @return the descricaoCondutas
	 */
	public String getDescricaoCondutas() {
		return descricaoCondutas;
	}

	/**
	 * @param descricaoCondutas the descricaoCondutas to set
	 */
	public void setDescricaoCondutas(String descricaoCondutas) {
		this.descricaoCondutas = descricaoCondutas;
	}

	/**
	 * @return the descricaoHabitosVicios
	 */
	public String getDescricaoHabitosVicios() {
		return descricaoHabitosVicios;
	}

	/**
	 * @param descricaoHabitosVicios the descricaoHabitosVicios to set
	 */
	public void setDescricaoHabitosVicios(String descricaoHabitosVicios) {
		this.descricaoHabitosVicios = descricaoHabitosVicios;
	}

	/**
	 * @return the listaPontos
	 */
	public List<Ponto> getListaPontos() {
		return listaPontos;
	}

	/**
	 * @param listaPontos the listaPontos to set
	 */
	public void setListaPontos(List<Ponto> listaPontos) {
		this.listaPontos = listaPontos;
	}
	
}