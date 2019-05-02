import { Paciente } from './../../../../model/paciente';
import { Sexo } from './../../../../model/sexo';
import { PacienteService } from './../../../../service/paciente.service';
import { Cidade } from './../../../../model/cidade';
import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { EnumService } from 'src/app/service/enum.service';
import { CidadeService } from 'src/app/service/cidade.service';

@Component({
  selector: 'app-cadastro-paciente',
  templateUrl: './cadastro-paciente.component.html',
  styleUrls: ['./cadastro-paciente.component.css']
})
export class CadastroPacienteComponent implements OnInit {

  paciente: Paciente = new Paciente();

  pacienteForm: FormGroup;

  listaEstadoCivil: string[] = [];

  listaCidade: Cidade[] = [];

  listaSexo: Sexo[] = [ new Sexo('MASC', 'Masculino'), new Sexo('FEM', 'Feminino') ];

  constructor(private pacienteService: PacienteService, private enumService: EnumService, private cidadeService: CidadeService) { }

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
    // carrega a lista de estado civil
    this.enumService.recuperarEnumsEstadoCivil().subscribe(data => {
      this.listaEstadoCivil = data;
    });
  }

  listarCidades(): void {
    // carrega a lista de cidades
    this.cidadeService.findByNomeContaining(this.paciente.endereco.cidade).subscribe(data => {
      this.listaCidade = data;
    });
  }

}
