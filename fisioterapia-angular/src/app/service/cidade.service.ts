import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FisioterapiaService } from './fisioterapia.service';
import { Cidade } from '../model/cidade';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Accept': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CidadeService extends FisioterapiaService {

  url: string = this.prefixUrl + '/cidade';

  constructor(private http: HttpClient) {
    super();
   }

   findByNomeContaining(cidade: Cidade): Observable<Cidade[]> {
    return this.http.post<Cidade[]>(this.url + '/findByNomeContaining', cidade, httpOptions);
  }

}
