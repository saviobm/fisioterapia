import { Paciente } from './paciente';
import { Patologia } from './patologia';
import { Ck } from './ck';

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
  descricaoLocal: string;
  descricaoTipo: string;
  descricaoGrau: string;
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

  constructor() { }

}
