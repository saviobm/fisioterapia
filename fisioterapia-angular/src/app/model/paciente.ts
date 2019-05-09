import { Endereco } from './endereco';
export class Paciente {

  id: number;
  nome: string;
  idade: number;
  estadoCivil: string;
  sexo: string;
  ocupacao: string;
  telefone: string;
  cpf: string;
  listaEndereco: Endereco[] = [];
  ativo: boolean;
  constructor() {}
}
