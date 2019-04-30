import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FisioterapiaService } from './fisioterapia.service';

@Injectable({
  providedIn: 'root'
})
export class EnumService extends FisioterapiaService {

  constructor(private http: HttpClient) {
    super();
  }

  url: string = '/enums';

  recuperarEnumsEstadoCivil(): Observable<string[]> {
    return this.http.get<string[]>(this.prefixUrl + this.url + '/estadoCivil');
  }

}
