import { Paciente } from './paciente';
import { Patologia } from './patologia';

export class Avaliacao {

  id: number;
  dataAvaliacao: Date;
  paciente: Paciente = new Paciente();
  descricaoOcupacao: string;
  patologia: Patologia = new Patologia();
  descDiagFisioterapeutico: string;
  cid: string;
  descricaoUsoMedicamentos: string;
  descricaoPrincipaisQueixas: string;
  descricaoHMA: string;

  constructor() { }

}
