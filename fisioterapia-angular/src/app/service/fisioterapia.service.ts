import { FisioterapiaMessagesComponent } from './../message/fisioterapia-messages/fisioterapia-messages.component';
import { Consulta } from './../model/consulta';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FisioterapiaService {

  public prefixUrl: string = 'http://localhost:9000/fisioterapia';

}
