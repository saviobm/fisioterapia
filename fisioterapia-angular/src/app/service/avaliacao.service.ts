import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Avaliacao } from './../model/avaliacao';
import { Injectable } from '@angular/core';
import { FisioterapiaService } from './fisioterapia.service';

@Injectable({
  providedIn: 'root'
})
export class AvaliacaoService extends FisioterapiaService {

  url: string = this.prefixUrl + '/avaliacao';

  constructor(private http: HttpClient) {
    super();
   }

  salvar(avaliacao: Avaliacao): Observable<Avaliacao> {
    return this.http.post<Avaliacao>(this.url + '/salvar', avaliacao);
  }

}
