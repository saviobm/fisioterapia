import { Cidade } from './cidade';
export class Endereco {
  id: number;
  endereco: string;
  cep: string;
  complemento: string;
  cidade: Cidade = new Cidade();
  ativo: boolean;

  constructor() {}
}
