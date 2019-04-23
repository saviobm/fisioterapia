import { HttpClient } from '@angular/common/http';
import { FisioterapiaService } from './fisioterapia.service';
import { Injectable } from '@angular/core';
import { Paciente } from '../model/paciente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService extends FisioterapiaService {

  url: string = this.prefixUrl + '/paciente';

  constructor(private http: HttpClient) {
    super();
  }

  listarPacientes(): Observable<Paciente[]> {
    return this.http.get<Paciente[]>(this.url + '/listarPacientes');
  }

}
