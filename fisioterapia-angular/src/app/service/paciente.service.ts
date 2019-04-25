import { HttpClient } from '@angular/common/http';
import { FisioterapiaService } from './fisioterapia.service';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SortDirection } from '@angular/material';
import { Paciente } from '../model/paciente';

@Injectable({
  providedIn: 'root'
})
export class PacienteService extends FisioterapiaService {

  url: string = this.prefixUrl + '/paciente';

  constructor(private http: HttpClient) {
    super();
  }

  listarPacientes(active: string, direction: SortDirection, pageIndex: number): Observable<ConsultaApi[]> {
    return this.http.get<ConsultaApi[]>(this.url + '/listarPacientes');
  }

}

export interface ConsultaApi {
  items: Paciente[];
  total_count: number;
}
