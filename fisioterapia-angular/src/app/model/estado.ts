import { Cidade } from './cidade';

export class Estado {
  id: number;
  sgEstado: string;
  nome: string;
  listaCidade: Cidade[] = [];
  constructor(){}
}
