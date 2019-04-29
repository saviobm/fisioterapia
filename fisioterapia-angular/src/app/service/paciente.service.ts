import { Paciente } from './../model/paciente';
import { map, catchError } from 'rxjs/operators';
import { Consulta } from './../model/consulta';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FisioterapiaService } from './fisioterapia.service';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SortDirection } from '@angular/material';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Origin': '*'
  })
};

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

  findByNomeContaining(paciente: Paciente): Observable<Consulta> {
    return this.http.post<Consulta>(this.url + '/findByNomeContaining', paciente);
  }

  salvar(paciente: Paciente): any {
    this.http.put(this.url + '/salvar', paciente).pipe(
      map(res => {
        return res;
      }),
      catchError(() => {
        console.log("Erro ao incluir um paciente.");
        return null;
      })
    )

  };

}
