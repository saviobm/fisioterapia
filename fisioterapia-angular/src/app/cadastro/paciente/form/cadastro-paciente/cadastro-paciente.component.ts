import { Paciente } from './../../../../model/paciente';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PacienteService } from 'src/app/service/paciente.service';

@Component({
  selector: 'app-cadastro-paciente',
  templateUrl: './cadastro-paciente.component.html',
  styleUrls: ['./cadastro-paciente.component.css']
})
export class CadastroPacienteComponent implements OnInit {

  paciente: Paciente = new Paciente(0, '');

  constructor(private pacienteService: PacienteService) { }

  ngOnInit() {
  }

  onSubmit(f: NgForm): void {
    this.pacienteService.salvar(this.paciente);
  }

}
