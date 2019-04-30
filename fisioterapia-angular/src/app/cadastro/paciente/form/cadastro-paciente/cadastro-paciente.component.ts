import { map } from 'rxjs/operators';
import { PacienteService } from './../../../../service/paciente.service';
import { Paciente } from './../../../../model/paciente';
import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { EnumService } from 'src/app/service/enum.service';

@Component({
  selector: 'app-cadastro-paciente',
  templateUrl: './cadastro-paciente.component.html',
  styleUrls: ['./cadastro-paciente.component.css']
})
export class CadastroPacienteComponent implements OnInit {

  paciente: Paciente = new Paciente(0, '');

  pacienteForm: FormGroup;

  listaEstadoCivil: string[] = [];

  constructor(private pacienteService: PacienteService, private enumService: EnumService) { }

  ngOnInit() {
    /*4this.pacienteForm = new FormGroup({
      'nome': new FormControl(this.paciente.nome, [
        Validators.required,
        Validators.minLength(4),
        forbiddenNameValidator(/paciente/i) // <-- Here's how you pass in the custom validator.
      ])
    });*/
    this.preencherCombos();
  }

  salvar(f: NgForm): void {
    this.pacienteService.salvar(this.paciente);
  }

  preencherCombos(): void {
    /*this.enumService.recuperarEnumsEstadoCivil().pipe(
      map(data => {
        this.listaEstadoCivil = data;
        return data;
      })
    );*/
      this.enumService.recuperarEnumsEstadoCivil().subscribe(data => {
        this.listaEstadoCivil = data;
      });
  }

}
