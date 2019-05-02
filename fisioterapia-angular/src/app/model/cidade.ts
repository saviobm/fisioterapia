import { Estado } from './estado';
import { Endereco } from './endereco';

export class Cidade {
  id: number;
  nome: string;
  estado: Estado;
  listaEndereco: Endereco[] = [];
  constructor(){}
}
