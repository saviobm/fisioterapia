import { Observable } from 'rxjs';
import { Patologia } from './../model/patologia';
import { HttpClient } from '@angular/common/http';
import { FisioterapiaService } from './fisioterapia.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PatologiaService extends FisioterapiaService {

  url: string = this.prefixUrl + '/patologia';

  constructor(private http: HttpClient) {
    super();
  }

  listarPatologias(): Observable<Patologia[]> {
    return this.http.get<Patologia[]>(this.url + '/listarPatologias');
  }

}
