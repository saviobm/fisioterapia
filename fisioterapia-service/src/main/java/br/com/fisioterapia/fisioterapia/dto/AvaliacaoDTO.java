package br.com.fisioterapia.fisioterapia.dto;

import java.util.Date;
import java.util.List;

import br.com.fisioterapia.fisioterapia.modelo.MiniMental;
import br.com.fisioterapia.fisioterapia.modelo.Patologia;

public class AvaliacaoDTO extends FisioterapiaDTO {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 5622811913228281958L;
	
	private Long id;
	private Date dataAvaliacao;
	private PacienteDTO paciente;
	private Patologia patologia;
	private String descricaoDiagFisioterapeutico;
	private String cid;
	private String descricaoOcupacao;
	private String descricaoUsoMedicamentos;
	private String descricaoPrincipaisQueixas;
	private String descricaoHMA;
	private MiniMental miniMental;
	private String descricaoAspectoSecrecao;
	private String descricaoAmplitudeArticular;
	private String   descricaoPele;
	private String descricaoLocal;
	private String descricaoTipo;
	private String descricaoGrau;
	private String descricaoSequelas;
	private String descricaoFatoresAgravantes;
	private String descricaoFatoresAtenuantes;
	private String descricaoObservacoes;
	private String descricaoObjetivos;
	private String descricaoCondutas;
	private List<Boolean> habitosVicios;
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
	public PacienteDTO getPaciente() {
		return paciente;
	}
	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(PacienteDTO paciente) {
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
	 * @return the habitosVicios
	 */
	public List<Boolean> getHabitosVicios() {
		return habitosVicios;
	}
	/**
	 * @param habitosVicios the habitosVicios to set
	 */
	public void setHabitosVicios(List<Boolean> habitosVicios) {
		this.habitosVicios = habitosVicios;
	}

}
