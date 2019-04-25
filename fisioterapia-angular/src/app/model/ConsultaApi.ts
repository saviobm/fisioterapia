import { Paciente } from './paciente';

export interface ConsultaApi {
  items: Paciente[];
  total_count: number;
}
