import { Component, OnInit } from '@angular/core';
import { Avaliacao } from '../../model/avaliacao'

@Component({
  selector: 'app-avaliacao',
  templateUrl: './avaliacao.component.html',
  styleUrls: ['./avaliacao.component.css']
})
export class AvaliacaoComponent implements OnInit {

  avaliacao: Avaliacao = new Avaliacao();

  constructor() { }

  ngOnInit() {
  }

}
