package br.com.fisioterapia.fisioterapia.dto;

import java.util.Date;
import java.util.List;

public class AvaliacaoDTO extends FisioterapiaDTO {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 5622811913228281958L;

	private Long id;
	private Date dataAvaliacao;
	private PacienteDTO paciente;
	private String descricaoOcupacao;
	private PatologiaDTO patologia;
	private String descricaoDiagFisioterapeutico;
	private String cid;
	private String descricaoUsoMedicamentos;
	private String descricaoPrincipaisQueixas;
	private String descricaoHMA;
	private String descricaoAspectoSecrecao;
	private String descricaoAmplitudeArticular;
	private String descricaoPele;
	private String descricaoEdemaLocal;
	private String descricaoEdemaTipo;
	private String descricaoEdemaGrau;
	private String descricaoSequelas;
	private String descricaoFatoresAgravantes;
	private String descricaoFatoresAtenuantes;
	private String descricaoObservacoes;
	private String descricaoDignosticoFisioterapeutico;
	private String descricaoObjetivos;
	private String descricaoCondutas;
	private List<CkDTO> listaHabitosVicios;
	private List<CkDTO> listaSinaisVitais;
	private List<CkDTO> listaNivelConsciencia;
	private List<CkDTO> listaEstadoEmocional;
	private List<CkDTO> listaSistemaRespiratorio;
	private List<CkDTO> listaRitmo;
	private List<CkDTO> listaPMRespiratorio;
	private List<CkDTO> listaExToracica;
	private List<CkDTO> listaAuscultaPulmonar;
	private List<CkDTO> listaRuidosAdventicios;
	private List<CkDTO> listaTosses;
	private List<CkDTO> listaSistemaOsteomioarticular;
	private List<CkDTO> listaForcaMuscular;
	private List<ForcaMuscularDTO> listaGridForcaMuscular;
	private List<AshworthDTO> listaEscalaAshworth;
	private List<CkDTO> listaAmplitudeArticular;
	private List<CkDTO> listaTipoEmatomaAA;
	private List<CkDTO> listaDeambulacao;
	private List<CkDTO> listaMarcha;
	private List<CkDTO> listaSensibilidade;
	private List<AdmDTO> listaCoordenacao;
	private List<AdmDTO> listaEquilibrio;
	private List<ForcaDTO> listaOsteotendinoso;
	private List<CkDTO> listaAparelhosDigestorio;
	private String descricaoAparelhoDigestorio;
	private List<CkDTO> listaAbdomem;
	private String descricaoAbdomem;
	private List<CkDTO> listaAparelhoGenitourinario;
	private String descricaoAparelhoGenitourinario;
	private List<CkDTO> listaTipoDores;
	private List<PontoDTO> listaPontos;
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
	 * @return the patologia
	 */
	public PatologiaDTO getPatologia() {
		return patologia;
	}
	/**
	 * @param patologia the patologia to set
	 */
	public void setPatologia(PatologiaDTO patologia) {
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
	 * @return the descricaoEdemaLocal
	 */
	public String getDescricaoEdemaLocal() {
		return descricaoEdemaLocal;
	}
	/**
	 * @param descricaoEdemaLocal the descricaoEdemaLocal to set
	 */
	public void setDescricaoEdemaLocal(String descricaoEdemaLocal) {
		this.descricaoEdemaLocal = descricaoEdemaLocal;
	}
	/**
	 * @return the descricaoEdemaTipo
	 */
	public String getDescricaoEdemaTipo() {
		return descricaoEdemaTipo;
	}
	/**
	 * @param descricaoEdemaTipo the descricaoEdemaTipo to set
	 */
	public void setDescricaoEdemaTipo(String descricaoEdemaTipo) {
		this.descricaoEdemaTipo = descricaoEdemaTipo;
	}
	/**
	 * @return the descricaoEdemaGrau
	 */
	public String getDescricaoEdemaGrau() {
		return descricaoEdemaGrau;
	}
	/**
	 * @param descricaoEdemaGrau the descricaoEdemaGrau to set
	 */
	public void setDescricaoEdemaGrau(String descricaoEdemaGrau) {
		this.descricaoEdemaGrau = descricaoEdemaGrau;
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
	 * @return the descricaoDignosticoFisioterapeutico
	 */
	public String getDescricaoDignosticoFisioterapeutico() {
		return descricaoDignosticoFisioterapeutico;
	}
	/**
	 * @param descricaoDignosticoFisioterapeutico the descricaoDignosticoFisioterapeutico to set
	 */
	public void setDescricaoDignosticoFisioterapeutico(String descricaoDignosticoFisioterapeutico) {
		this.descricaoDignosticoFisioterapeutico = descricaoDignosticoFisioterapeutico;
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
	 * @return the listaHabitosVicios
	 */
	public List<CkDTO> getListaHabitosVicios() {
		return listaHabitosVicios;
	}
	/**
	 * @param listaHabitosVicios the listaHabitosVicios to set
	 */
	public void setListaHabitosVicios(List<CkDTO> listaHabitosVicios) {
		this.listaHabitosVicios = listaHabitosVicios;
	}
	/**
	 * @return the listaSinaisVitais
	 */
	public List<CkDTO> getListaSinaisVitais() {
		return listaSinaisVitais;
	}
	/**
	 * @param listaSinaisVitais the listaSinaisVitais to set
	 */
	public void setListaSinaisVitais(List<CkDTO> listaSinaisVitais) {
		this.listaSinaisVitais = listaSinaisVitais;
	}
	/**
	 * @return the listaNivelConsciencia
	 */
	public List<CkDTO> getListaNivelConsciencia() {
		return listaNivelConsciencia;
	}
	/**
	 * @param listaNivelConsciencia the listaNivelConsciencia to set
	 */
	public void setListaNivelConsciencia(List<CkDTO> listaNivelConsciencia) {
		this.listaNivelConsciencia = listaNivelConsciencia;
	}
	/**
	 * @return the listaEstadoEmocional
	 */
	public List<CkDTO> getListaEstadoEmocional() {
		return listaEstadoEmocional;
	}
	/**
	 * @param listaEstadoEmocional the listaEstadoEmocional to set
	 */
	public void setListaEstadoEmocional(List<CkDTO> listaEstadoEmocional) {
		this.listaEstadoEmocional = listaEstadoEmocional;
	}
	/**
	 * @return the listaSistemaRespiratorio
	 */
	public List<CkDTO> getListaSistemaRespiratorio() {
		return listaSistemaRespiratorio;
	}
	/**
	 * @param listaSistemaRespiratorio the listaSistemaRespiratorio to set
	 */
	public void setListaSistemaRespiratorio(List<CkDTO> listaSistemaRespiratorio) {
		this.listaSistemaRespiratorio = listaSistemaRespiratorio;
	}
	/**
	 * @return the listaRitmo
	 */
	public List<CkDTO> getListaRitmo() {
		return listaRitmo;
	}
	/**
	 * @param listaRitmo the listaRitmo to set
	 */
	public void setListaRitmo(List<CkDTO> listaRitmo) {
		this.listaRitmo = listaRitmo;
	}
	/**
	 * @return the listaPMRespiratorio
	 */
	public List<CkDTO> getListaPMRespiratorio() {
		return listaPMRespiratorio;
	}
	/**
	 * @param listaPMRespiratorio the listaPMRespiratorio to set
	 */
	public void setListaPMRespiratorio(List<CkDTO> listaPMRespiratorio) {
		this.listaPMRespiratorio = listaPMRespiratorio;
	}
	/**
	 * @return the listaExToracica
	 */
	public List<CkDTO> getListaExToracica() {
		return listaExToracica;
	}
	/**
	 * @param listaExToracica the listaExToracica to set
	 */
	public void setListaExToracica(List<CkDTO> listaExToracica) {
		this.listaExToracica = listaExToracica;
	}
	/**
	 * @return the listaAuscultaPulmonar
	 */
	public List<CkDTO> getListaAuscultaPulmonar() {
		return listaAuscultaPulmonar;
	}
	/**
	 * @param listaAuscultaPulmonar the listaAuscultaPulmonar to set
	 */
	public void setListaAuscultaPulmonar(List<CkDTO> listaAuscultaPulmonar) {
		this.listaAuscultaPulmonar = listaAuscultaPulmonar;
	}
	/**
	 * @return the listaRuidosAdventicios
	 */
	public List<CkDTO> getListaRuidosAdventicios() {
		return listaRuidosAdventicios;
	}
	/**
	 * @param listaRuidosAdventicios the listaRuidosAdventicios to set
	 */
	public void setListaRuidosAdventicios(List<CkDTO> listaRuidosAdventicios) {
		this.listaRuidosAdventicios = listaRuidosAdventicios;
	}
	/**
	 * @return the listaTosses
	 */
	public List<CkDTO> getListaTosses() {
		return listaTosses;
	}
	/**
	 * @param listaTosses the listaTosses to set
	 */
	public void setListaTosses(List<CkDTO> listaTosses) {
		this.listaTosses = listaTosses;
	}
	/**
	 * @return the listaSistemaOsteomioarticular
	 */
	public List<CkDTO> getListaSistemaOsteomioarticular() {
		return listaSistemaOsteomioarticular;
	}
	/**
	 * @param listaSistemaOsteomioarticular the listaSistemaOsteomioarticular to set
	 */
	public void setListaSistemaOsteomioarticular(List<CkDTO> listaSistemaOsteomioarticular) {
		this.listaSistemaOsteomioarticular = listaSistemaOsteomioarticular;
	}
	/**
	 * @return the listaForcaMuscular
	 */
	public List<CkDTO> getListaForcaMuscular() {
		return listaForcaMuscular;
	}
	/**
	 * @param listaForcaMuscular the listaForcaMuscular to set
	 */
	public void setListaForcaMuscular(List<CkDTO> listaForcaMuscular) {
		this.listaForcaMuscular = listaForcaMuscular;
	}
	/**
	 * @return the listaGridForcaMuscular
	 */
	public List<ForcaMuscularDTO> getListaGridForcaMuscular() {
		return listaGridForcaMuscular;
	}
	/**
	 * @param listaGridForcaMuscular the listaGridForcaMuscular to set
	 */
	public void setListaGridForcaMuscular(List<ForcaMuscularDTO> listaGridForcaMuscular) {
		this.listaGridForcaMuscular = listaGridForcaMuscular;
	}
	/**
	 * @return the listaEscalaAshworth
	 */
	public List<AshworthDTO> getListaEscalaAshworth() {
		return listaEscalaAshworth;
	}
	/**
	 * @param listaEscalaAshworth the listaEscalaAshworth to set
	 */
	public void setListaEscalaAshworth(List<AshworthDTO> listaEscalaAshworth) {
		this.listaEscalaAshworth = listaEscalaAshworth;
	}
	/**
	 * @return the listaAmplitudeArticular
	 */
	public List<CkDTO> getListaAmplitudeArticular() {
		return listaAmplitudeArticular;
	}
	/**
	 * @param listaAmplitudeArticular the listaAmplitudeArticular to set
	 */
	public void setListaAmplitudeArticular(List<CkDTO> listaAmplitudeArticular) {
		this.listaAmplitudeArticular = listaAmplitudeArticular;
	}
	/**
	 * @return the listaTipoEmatomaAA
	 */
	public List<CkDTO> getListaTipoEmatomaAA() {
		return listaTipoEmatomaAA;
	}
	/**
	 * @param listaTipoEmatomaAA the listaTipoEmatomaAA to set
	 */
	public void setListaTipoEmatomaAA(List<CkDTO> listaTipoEmatomaAA) {
		this.listaTipoEmatomaAA = listaTipoEmatomaAA;
	}
	/**
	 * @return the listaDeambulacao
	 */
	public List<CkDTO> getListaDeambulacao() {
		return listaDeambulacao;
	}
	/**
	 * @param listaDeambulacao the listaDeambulacao to set
	 */
	public void setListaDeambulacao(List<CkDTO> listaDeambulacao) {
		this.listaDeambulacao = listaDeambulacao;
	}
	/**
	 * @return the listaMarcha
	 */
	public List<CkDTO> getListaMarcha() {
		return listaMarcha;
	}
	/**
	 * @param listaMarcha the listaMarcha to set
	 */
	public void setListaMarcha(List<CkDTO> listaMarcha) {
		this.listaMarcha = listaMarcha;
	}
	/**
	 * @return the listaSensibilidade
	 */
	public List<CkDTO> getListaSensibilidade() {
		return listaSensibilidade;
	}
	/**
	 * @param listaSensibilidade the listaSensibilidade to set
	 */
	public void setListaSensibilidade(List<CkDTO> listaSensibilidade) {
		this.listaSensibilidade = listaSensibilidade;
	}
	/**
	 * @return the listaCoordenacao
	 */
	public List<AdmDTO> getListaCoordenacao() {
		return listaCoordenacao;
	}
	/**
	 * @param listaCoordenacao the listaCoordenacao to set
	 */
	public void setListaCoordenacao(List<AdmDTO> listaCoordenacao) {
		this.listaCoordenacao = listaCoordenacao;
	}
	/**
	 * @return the listaEquilibrio
	 */
	public List<AdmDTO> getListaEquilibrio() {
		return listaEquilibrio;
	}
	/**
	 * @param listaEquilibrio the listaEquilibrio to set
	 */
	public void setListaEquilibrio(List<AdmDTO> listaEquilibrio) {
		this.listaEquilibrio = listaEquilibrio;
	}
	/**
	 * @return the listaOsteotendinoso
	 */
	public List<ForcaDTO> getListaOsteotendinoso() {
		return listaOsteotendinoso;
	}
	/**
	 * @param listaOsteotendinoso the listaOsteotendinoso to set
	 */
	public void setListaOsteotendinoso(List<ForcaDTO> listaOsteotendinoso) {
		this.listaOsteotendinoso = listaOsteotendinoso;
	}
	/**
	 * @return the listaAparelhosDigestorio
	 */
	public List<CkDTO> getListaAparelhosDigestorio() {
		return listaAparelhosDigestorio;
	}
	/**
	 * @param listaAparelhosDigestorio the listaAparelhosDigestorio to set
	 */
	public void setListaAparelhosDigestorio(List<CkDTO> listaAparelhosDigestorio) {
		this.listaAparelhosDigestorio = listaAparelhosDigestorio;
	}
	/**
	 * @return the descricaoAparelhoDigestorio
	 */
	public String getDescricaoAparelhoDigestorio() {
		return descricaoAparelhoDigestorio;
	}
	/**
	 * @param descricaoAparelhoDigestorio the descricaoAparelhoDigestorio to set
	 */
	public void setDescricaoAparelhoDigestorio(String descricaoAparelhoDigestorio) {
		this.descricaoAparelhoDigestorio = descricaoAparelhoDigestorio;
	}
	/**
	 * @return the listaAbdomem
	 */
	public List<CkDTO> getListaAbdomem() {
		return listaAbdomem;
	}
	/**
	 * @param listaAbdomem the listaAbdomem to set
	 */
	public void setListaAbdomem(List<CkDTO> listaAbdomem) {
		this.listaAbdomem = listaAbdomem;
	}
	/**
	 * @return the descricaoAbdomem
	 */
	public String getDescricaoAbdomem() {
		return descricaoAbdomem;
	}
	/**
	 * @param descricaoAbdomem the descricaoAbdomem to set
	 */
	public void setDescricaoAbdomem(String descricaoAbdomem) {
		this.descricaoAbdomem = descricaoAbdomem;
	}
	/**
	 * @return the listaAparelhoGenitourinario
	 */
	public List<CkDTO> getListaAparelhoGenitourinario() {
		return listaAparelhoGenitourinario;
	}
	/**
	 * @param listaAparelhoGenitourinario the listaAparelhoGenitourinario to set
	 */
	public void setListaAparelhoGenitourinario(List<CkDTO> listaAparelhoGenitourinario) {
		this.listaAparelhoGenitourinario = listaAparelhoGenitourinario;
	}
	/**
	 * @return the descricaoAparelhoGenitourinario
	 */
	public String getDescricaoAparelhoGenitourinario() {
		return descricaoAparelhoGenitourinario;
	}
	/**
	 * @param descricaoAparelhoGenitourinario the descricaoAparelhoGenitourinario to set
	 */
	public void setDescricaoAparelhoGenitourinario(String descricaoAparelhoGenitourinario) {
		this.descricaoAparelhoGenitourinario = descricaoAparelhoGenitourinario;
	}
	/**
	 * @return the listaTipoDores
	 */
	public List<CkDTO> getListaTipoDores() {
		return listaTipoDores;
	}
	/**
	 * @param listaTipoDores the listaTipoDores to set
	 */
	public void setListaTipoDores(List<CkDTO> listaTipoDores) {
		this.listaTipoDores = listaTipoDores;
	}
	/**
	 * @return the listaPontos
	 */
	public List<PontoDTO> getListaPontos() {
		return listaPontos;
	}
	/**
	 * @param listaPontos the listaPontos to set
	 */
	public void setListaPontos(List<PontoDTO> listaPontos) {
		this.listaPontos = listaPontos;
	}
	
}