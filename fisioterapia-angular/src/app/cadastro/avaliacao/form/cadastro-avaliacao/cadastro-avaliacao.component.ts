import { MensagemComponent } from 'src/app/mensagem/mensagem.component';
import { Message } from './../../../../model/message';
import { MatDialog } from '@angular/material';
import { Mensagem } from './../../../paciente/form/cadastro-paciente/cadastro-paciente.component';
import { PacienteService } from './../../../../service/paciente.service';
import { Avaliacao } from './../../../../model/avaliacao';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro-avaliacao',
  templateUrl: './cadastro-avaliacao.component.html',
  styleUrls: ['./cadastro-avaliacao.component.css']
})
export class CadastroAvaliacaoComponent implements OnInit {

  constructor(private pacienteService: PacienteService, private dialog: MatDialog) { }

  avaliacao: Avaliacao = new Avaliacao();

  ngOnInit() {
    this.inicializarVariaveis();
  }

  inicializarVariaveis(): void {
    this.avaliacao = new Avaliacao();
  }

  pesquisarPaciente() {
    if (this.avaliacao.paciente.cpf) {
      this.pacienteService.pesquisarPaciente(this.avaliacao.paciente).subscribe(data => {
        if (data) {
          this.avaliacao.paciente = data.items[0];
        } else {
          let msg = new Message();
          msg.message = 'Paciente não encontrado!';
          msg.title = 'Pesquisa Paciente';
          this.openDialog(msg);
        }
      });
      console.log(this.avaliacao.paciente.cpf);
    }
  }

  openDialog(message: Message): void {
    const dialogRef = this.dialog.open(MensagemComponent, {
      height: '400px',
      width: '600px',
      data: message
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) { }
    });
  }

}
