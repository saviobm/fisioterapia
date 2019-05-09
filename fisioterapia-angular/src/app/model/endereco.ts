import { Paciente } from './paciente';
import { Cidade } from './cidade';
export class Endereco {
  id: number;
  descricaoEndereco: string;
  cep: string;
  complemento: string;
  cidade: Cidade = new Cidade();
  ativo: boolean;
  constructor() {}
}
