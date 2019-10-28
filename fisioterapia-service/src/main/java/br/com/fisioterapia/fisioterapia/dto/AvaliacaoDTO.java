package br.com.fisioterapia.fisioterapia.dto;

import java.util.Date;
import java.util.List;

import br.com.fisioterapia.fisioterapia.modelo.Patologia;

public class AvaliacaoDTO extends FisioterapiaDTO {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 5622811913228281958L;

	private Long id;
	private Date dataAvaliacao;
	private PacienteDTO paciente;
	private String descricaoOcupacao;
	private Patologia patologia;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}
	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}
	public PacienteDTO getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
	}
	public String getDescricaoOcupacao() {
		return descricaoOcupacao;
	}
	public void setDescricaoOcupacao(String descricaoOcupacao) {
		this.descricaoOcupacao = descricaoOcupacao;
	}
	public Patologia getPatologia() {
		return patologia;
	}
	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}
	public String getDescricaoDiagFisioterapeutico() {
		return descricaoDiagFisioterapeutico;
	}
	public void setDescricaoDiagFisioterapeutico(String descricaoDiagFisioterapeutico) {
		this.descricaoDiagFisioterapeutico = descricaoDiagFisioterapeutico;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getDescricaoUsoMedicamentos() {
		return descricaoUsoMedicamentos;
	}
	public void setDescricaoUsoMedicamentos(String descricaoUsoMedicamentos) {
		this.descricaoUsoMedicamentos = descricaoUsoMedicamentos;
	}
	public String getDescricaoPrincipaisQueixas() {
		return descricaoPrincipaisQueixas;
	}
	public void setDescricaoPrincipaisQueixas(String descricaoPrincipaisQueixas) {
		this.descricaoPrincipaisQueixas = descricaoPrincipaisQueixas;
	}
	public String getDescricaoHMA() {
		return descricaoHMA;
	}
	public void setDescricaoHMA(String descricaoHMA) {
		this.descricaoHMA = descricaoHMA;
	}
	public String getDescricaoAspectoSecrecao() {
		return descricaoAspectoSecrecao;
	}
	public void setDescricaoAspectoSecrecao(String descricaoAspectoSecrecao) {
		this.descricaoAspectoSecrecao = descricaoAspectoSecrecao;
	}
	public String getDescricaoAmplitudeArticular() {
		return descricaoAmplitudeArticular;
	}
	public void setDescricaoAmplitudeArticular(String descricaoAmplitudeArticular) {
		this.descricaoAmplitudeArticular = descricaoAmplitudeArticular;
	}
	public String getDescricaoPele() {
		return descricaoPele;
	}
	public void setDescricaoPele(String descricaoPele) {
		this.descricaoPele = descricaoPele;
	}
	public String getDescricaoEdemaLocal() {
		return descricaoEdemaLocal;
	}
	public void setDescricaoEdemaLocal(String descricaoEdemaLocal) {
		this.descricaoEdemaLocal = descricaoEdemaLocal;
	}
	public String getDescricaoEdemaTipo() {
		return descricaoEdemaTipo;
	}
	public void setDescricaoEdemaTipo(String descricaoEdemaTipo) {
		this.descricaoEdemaTipo = descricaoEdemaTipo;
	}
	public String getDescricaoEdemaGrau() {
		return descricaoEdemaGrau;
	}
	public void setDescricaoEdemaGrau(String descricaoEdemaGrau) {
		this.descricaoEdemaGrau = descricaoEdemaGrau;
	}
	public String getDescricaoSequelas() {
		return descricaoSequelas;
	}
	public void setDescricaoSequelas(String descricaoSequelas) {
		this.descricaoSequelas = descricaoSequelas;
	}
	public String getDescricaoFatoresAgravantes() {
		return descricaoFatoresAgravantes;
	}
	public void setDescricaoFatoresAgravantes(String descricaoFatoresAgravantes) {
		this.descricaoFatoresAgravantes = descricaoFatoresAgravantes;
	}
	public String getDescricaoFatoresAtenuantes() {
		return descricaoFatoresAtenuantes;
	}
	public void setDescricaoFatoresAtenuantes(String descricaoFatoresAtenuantes) {
		this.descricaoFatoresAtenuantes = descricaoFatoresAtenuantes;
	}
	public String getDescricaoObservacoes() {
		return descricaoObservacoes;
	}
	public void setDescricaoObservacoes(String descricaoObservacoes) {
		this.descricaoObservacoes = descricaoObservacoes;
	}
	public String getDescricaoDignosticoFisioterapeutico() {
		return descricaoDignosticoFisioterapeutico;
	}
	public void setDescricaoDignosticoFisioterapeutico(String descricaoDignosticoFisioterapeutico) {
		this.descricaoDignosticoFisioterapeutico = descricaoDignosticoFisioterapeutico;
	}
	public String getDescricaoObjetivos() {
		return descricaoObjetivos;
	}
	public void setDescricaoObjetivos(String descricaoObjetivos) {
		this.descricaoObjetivos = descricaoObjetivos;
	}
	public String getDescricaoCondutas() {
		return descricaoCondutas;
	}
	public void setDescricaoCondutas(String descricaoCondutas) {
		this.descricaoCondutas = descricaoCondutas;
	}
	public List<CkDTO> getListaHabitosVicios() {
		return listaHabitosVicios;
	}
	public void setListaHabitosVicios(List<CkDTO> listaHabitosVicios) {
		this.listaHabitosVicios = listaHabitosVicios;
	}
	public List<CkDTO> getListaSinaisVitais() {
		return listaSinaisVitais;
	}
	public void setListaSinaisVitais(List<CkDTO> listaSinaisVitais) {
		this.listaSinaisVitais = listaSinaisVitais;
	}
	public List<CkDTO> getListaNivelConsciencia() {
		return listaNivelConsciencia;
	}
	public void setListaNivelConsciencia(List<CkDTO> listaNivelConsciencia) {
		this.listaNivelConsciencia = listaNivelConsciencia;
	}
	public List<CkDTO> getListaEstadoEmocional() {
		return listaEstadoEmocional;
	}
	public void setListaEstadoEmocional(List<CkDTO> listaEstadoEmocional) {
		this.listaEstadoEmocional = listaEstadoEmocional;
	}
	public List<CkDTO> getListaSistemaRespiratorio() {
		return listaSistemaRespiratorio;
	}
	public void setListaSistemaRespiratorio(List<CkDTO> listaSistemaRespiratorio) {
		this.listaSistemaRespiratorio = listaSistemaRespiratorio;
	}
	public List<CkDTO> getListaRitmo() {
		return listaRitmo;
	}
	public void setListaRitmo(List<CkDTO> listaRitmo) {
		this.listaRitmo = listaRitmo;
	}
	public List<CkDTO> getListaPMRespiratorio() {
		return listaPMRespiratorio;
	}
	public void setListaPMRespiratorio(List<CkDTO> listaPMRespiratorio) {
		this.listaPMRespiratorio = listaPMRespiratorio;
	}
	public List<CkDTO> getListaExToracica() {
		return listaExToracica;
	}
	public void setListaExToracica(List<CkDTO> listaExToracica) {
		this.listaExToracica = listaExToracica;
	}
	public List<CkDTO> getListaAuscultaPulmonar() {
		return listaAuscultaPulmonar;
	}
	public void setListaAuscultaPulmonar(List<CkDTO> listaAuscultaPulmonar) {
		this.listaAuscultaPulmonar = listaAuscultaPulmonar;
	}
	public List<CkDTO> getListaRuidosAdventicios() {
		return listaRuidosAdventicios;
	}
	public void setListaRuidosAdventicios(List<CkDTO> listaRuidosAdventicios) {
		this.listaRuidosAdventicios = listaRuidosAdventicios;
	}
	public List<CkDTO> getListaTosses() {
		return listaTosses;
	}
	public void setListaTosses(List<CkDTO> listaTosses) {
		this.listaTosses = listaTosses;
	}
	public List<CkDTO> getListaSistemaOsteomioarticular() {
		return listaSistemaOsteomioarticular;
	}
	public void setListaSistemaOsteomioarticular(List<CkDTO> listaSistemaOsteomioarticular) {
		this.listaSistemaOsteomioarticular = listaSistemaOsteomioarticular;
	}
	public List<CkDTO> getListaForcaMuscular() {
		return listaForcaMuscular;
	}
	public void setListaForcaMuscular(List<CkDTO> listaForcaMuscular) {
		this.listaForcaMuscular = listaForcaMuscular;
	}
	public List<ForcaMuscularDTO> getListaGridForcaMuscular() {
		return listaGridForcaMuscular;
	}
	public void setListaGridForcaMuscular(List<ForcaMuscularDTO> listaGridForcaMuscular) {
		this.listaGridForcaMuscular = listaGridForcaMuscular;
	}
	public List<AshworthDTO> getListaEscalaAshworth() {
		return listaEscalaAshworth;
	}
	public void setListaEscalaAshworth(List<AshworthDTO> listaEscalaAshworth) {
		this.listaEscalaAshworth = listaEscalaAshworth;
	}
	public List<CkDTO> getListaAmplitudeArticular() {
		return listaAmplitudeArticular;
	}
	public void setListaAmplitudeArticular(List<CkDTO> listaAmplitudeArticular) {
		this.listaAmplitudeArticular = listaAmplitudeArticular;
	}
	public List<CkDTO> getListaTipoEmatomaAA() {
		return listaTipoEmatomaAA;
	}
	public void setListaTipoEmatomaAA(List<CkDTO> listaTipoEmatomaAA) {
		this.listaTipoEmatomaAA = listaTipoEmatomaAA;
	}
	public List<CkDTO> getListaDeambulacao() {
		return listaDeambulacao;
	}
	public void setListaDeambulacao(List<CkDTO> listaDeambulacao) {
		this.listaDeambulacao = listaDeambulacao;
	}
	public List<CkDTO> getListaMarcha() {
		return listaMarcha;
	}
	public void setListaMarcha(List<CkDTO> listaMarcha) {
		this.listaMarcha = listaMarcha;
	}
	public List<CkDTO> getListaSensibilidade() {
		return listaSensibilidade;
	}
	public void setListaSensibilidade(List<CkDTO> listaSensibilidade) {
		this.listaSensibilidade = listaSensibilidade;
	}
	public List<AdmDTO> getListaCoordenacao() {
		return listaCoordenacao;
	}
	public void setListaCoordenacao(List<AdmDTO> listaCoordenacao) {
		this.listaCoordenacao = listaCoordenacao;
	}
	public List<AdmDTO> getListaEquilibrio() {
		return listaEquilibrio;
	}
	public void setListaEquilibrio(List<AdmDTO> listaEquilibrio) {
		this.listaEquilibrio = listaEquilibrio;
	}
	public List<ForcaDTO> getListaOsteotendinoso() {
		return listaOsteotendinoso;
	}
	public void setListaOsteotendinoso(List<ForcaDTO> listaOsteotendinoso) {
		this.listaOsteotendinoso = listaOsteotendinoso;
	}
	public List<CkDTO> getListaAparelhosDigestorio() {
		return listaAparelhosDigestorio;
	}
	public void setListaAparelhosDigestorio(List<CkDTO> listaAparelhosDigestorio) {
		this.listaAparelhosDigestorio = listaAparelhosDigestorio;
	}
	public String getDescricaoAparelhoDigestorio() {
		return descricaoAparelhoDigestorio;
	}
	public void setDescricaoAparelhoDigestorio(String descricaoAparelhoDigestorio) {
		this.descricaoAparelhoDigestorio = descricaoAparelhoDigestorio;
	}
	public List<CkDTO> getListaAbdomem() {
		return listaAbdomem;
	}
	public void setListaAbdomem(List<CkDTO> listaAbdomem) {
		this.listaAbdomem = listaAbdomem;
	}
	public String getDescricaoAbdomem() {
		return descricaoAbdomem;
	}
	public void setDescricaoAbdomem(String descricaoAbdomem) {
		this.descricaoAbdomem = descricaoAbdomem;
	}
	public List<CkDTO> getListaAparelhoGenitourinario() {
		return listaAparelhoGenitourinario;
	}
	public void setListaAparelhoGenitourinario(List<CkDTO> listaAparelhoGenitourinario) {
		this.listaAparelhoGenitourinario = listaAparelhoGenitourinario;
	}
	public String getDescricaoAparelhoGenitourinario() {
		return descricaoAparelhoGenitourinario;
	}
	public void setDescricaoAparelhoGenitourinario(String descricaoAparelhoGenitourinario) {
		this.descricaoAparelhoGenitourinario = descricaoAparelhoGenitourinario;
	}
	public List<CkDTO> getListaTipoDores() {
		return listaTipoDores;
	}
	public void setListaTipoDores(List<CkDTO> listaTipoDores) {
		this.listaTipoDores = listaTipoDores;
	}
	public List<PontoDTO> getListaPontos() {
		return listaPontos;
	}
	public void setListaPontos(List<PontoDTO> listaPontos) {
		this.listaPontos = listaPontos;
	}

}