import { Router } from '@angular/router';
import { Paciente } from './../model/paciente';
import { Consulta } from './../model/consulta';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FisioterapiaService } from './fisioterapia.service';
import { Injectable, Inject, Component } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { SortDirection, MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
  //'Access-Control-Allow-Origin': '*'
};

@Injectable({
  providedIn: 'root'
})
export class PacienteService extends FisioterapiaService {

  url: string = this.prefixUrl + '/paciente';

  constructor(private http: HttpClient, private router: Router) {
    super();
  }

  listarPacientes(active: string, direction: SortDirection, pageIndex: number): Observable<Consulta> {
    return this.http.get<Consulta>(this.url + '/listarPacientes/' + direction + '/' + pageIndex);
  }

  findByNomeContaining(paciente: Paciente): Observable<Consulta> {
    return this.http.post<Consulta>(this.url + '/findByNomeContaining', paciente);
  }

  salvar(paciente: Paciente): any {
    this.http.put<Paciente>(this.url + '/salvar', paciente).subscribe(data => {
            this.router.navigate(['/cadastro-paciente']);
            return data;
          });
  };

}
