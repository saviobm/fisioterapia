import { Ponto } from './ponto';
import { Forca } from 'src/app/model/forca';
import { Ashworth } from './ashworth';
import { ForcaMuscular } from './forca-muscular';
import { Paciente } from './paciente';
import { Patologia } from './patologia';
import { Ck } from './ck';
import { Adm } from './adm';

export class Avaliacao {

  id: number;
  dataAvaliacao: Date = new Date();
  paciente: Paciente = new Paciente();
  descricaoOcupacao: string;
  patologia: Patologia = new Patologia();
  descricaoDiagFisioterapeutico: string;
  cid: string;
  descricaoUsoMedicamentos: string;
  descricaoPrincipaisQueixas: string;
  descricaoHMA: string;
  descricaoAspectoSecrecao: string;
  descricaoAmplitudeArticular: string;
  descricaoPele: string;
  descricaoEdemaLocal: string;
  descricaoEdemaTipo: string;
  descricaoEdemaGrau: string;
  descricaoSequelas: string;
  descricaoFatoresAgravantes: string;
  descricaoFatoresAtenuantes: string;
  descricaoObservacoes: string;
  descricaoDignosticoFisioterapeutico: string;
  descricaoObjetivos: string;
  descricaoCondutas: string;
  listaHabitosVicios: Ck[] = [];
  listaSinaisVitais: Ck[] = [];
  listaNivelConsciencia: Ck[] = [];
  listaEstadoEmocional: Ck[] = [];
  listaSistemaRespiratorio: Ck[] = [];
  listaRitmo: Ck[] = [];
  listaPMRespiratorio: Ck[] = [];
  listaExToracica: Ck[] = [];
  listaAuscultaPulmonar: Ck[] = [];
  listaRuidosAdventicios: Ck[] = [];
  listaTosses: Ck[] = [];
  listaSistemaOsteomioarticular: Ck[] = [];
  listaForcaMuscular: Ck[] = [];
  listaGridForcaMuscular: ForcaMuscular[] = [];
  listaEscalaAshworth: Ashworth[] = [];
  listaAmplitudeArticular: Ck[] = [];
  listaTipoEmatomaAA: Ck[] = [];
  listaDeambulacao: Ck[] = [];
  listaMarcha: Ck[] = [];
  listaSensibilidade: Ck[] = [];
  listaCoordenacao: Adm[] = [];
  listaEquilibrio: Adm[] = [];
  listaOsteotendinoso: Forca[] = [];
  listaAparelhosDigestorio: Ck[] = [];
  descricaoAparelhoDigestorio: string;
  listaAbdomem: Ck[] = [];
  descricaoAbdomem: string;
  listaAparelhoGenitourinario: Ck[] = [];
  descricaoAparelhoGenitourinario: string;
  listaTipoDores: Ck[] = [];
  listaPontos: Ponto[] = [];

  constructor() { }

}
