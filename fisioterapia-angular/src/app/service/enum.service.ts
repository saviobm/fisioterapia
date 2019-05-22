import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FisioterapiaService } from './fisioterapia.service';
import { Enum } from '../model/enum';

@Injectable({
  providedIn: 'root'
})
export class EnumService extends FisioterapiaService {

  constructor(private http: HttpClient) {
    super();
  }

  url: string = '/enums';

  recuperarEnumsEstadoCivil(): Observable<Enum[]> {
    return this.http.get<Enum[]>(this.prefixUrl + this.url + '/estadoCivil');
  }

}
