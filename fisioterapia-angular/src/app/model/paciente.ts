import { Sexo } from './sexo';
import { Endereco } from './endereco';
export class Paciente {

  id: number;
  nome: string;
  idade: number;
  estadoCivil: string;
  sexo: string;
  ocupacao: string;
  listaEndereco: Endereco[] = [];
  telefone: string;
  cpf: string;
  ativo: boolean;
  constructor() {}
}
