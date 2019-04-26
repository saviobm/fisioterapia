import { Consulta } from './../model/consulta';
import { HttpClient } from '@angular/common/http';
import { FisioterapiaService } from './fisioterapia.service';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SortDirection } from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class PacienteService extends FisioterapiaService {

  url: string = this.prefixUrl + '/paciente';

  constructor(private http: HttpClient) {
    super();
  }

  listarPacientes(active: string, direction: SortDirection, pageIndex: number): Observable<Consulta> {
    return this.http.get<Consulta>(this.url + '/listarPacientes/' + direction + '/' + pageIndex);
  }

  listarPacientesFindByNomeContaining(): Observable<Consulta> {
    return this.http.get<Consulta>(this.url + '/listarPacientes/NomeContaining');
  }

}
