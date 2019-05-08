import { Sexo } from './sexo';
import { Endereco } from './endereco';
export class Paciente {

  id: number;
  nome: string;
  idade: number;
  estadoCivil: string;
  sexo: Sexo;
  ocupacao: string;
  endereco: Endereco = new Endereco();
  telefone: string;
  cpf: string;

  constructor() {}
}
