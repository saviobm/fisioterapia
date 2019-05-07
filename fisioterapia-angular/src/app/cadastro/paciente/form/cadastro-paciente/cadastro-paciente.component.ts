import { map, startWith } from 'rxjs/operators';
import { Paciente } from './../../../../model/paciente';
import { Sexo } from './../../../../model/sexo';
import { PacienteService } from './../../../../service/paciente.service';
import { Cidade } from './../../../../model/cidade';
import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormControl, FormsModule, NgControl } from '@angular/forms';
import { EnumService } from 'src/app/service/enum.service';
import { CidadeService } from 'src/app/service/cidade.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cadastro-paciente',
  templateUrl: './cadastro-paciente.component.html',
  styleUrls: ['./cadastro-paciente.component.css']
})
export class CadastroPacienteComponent implements OnInit {

  paciente: Paciente = new Paciente();

  pacienteForm: FormGroup;

  listaEstadoCivil: string[] = [];

  listaCidade: Cidade[];

  filteredOptionsCidade: Observable<Cidade[]>;

  options: string[] = ['One', 'Two', 'Three'];
  filteredOptions: Observable<string[]>;

  myControl = new FormControl();

  cidadeCtrl: FormControl = new FormControl();

  listaSexo: Sexo[] = [ new Sexo('MASC', 'Masculino'), new Sexo('FEM', 'Feminino') ];

  constructor(private pacienteService: PacienteService, private enumService: EnumService, private cidadeService: CidadeService) { }

  ngOnInit() {
    this.preencherCombos();
      this.filteredOptions = this.myControl.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      );
  }

  salvar(f: NgForm): void {
    this.pacienteService.salvar(this.paciente);
  }

  preencherCombos(): void {
    // carrega a lista de estado civil
    this.enumService.recuperarEnumsEstadoCivil().subscribe(data => {
      this.listaEstadoCivil = data;
    });

    // carrega a lista de cidades
    this.cidadeService.findAll().subscribe(data => {
      this.listaCidade = data;
    });

    // carrega a lista de cidades
    this.cidadeCtrl.valueChanges.pipe(
        startWith(''),
        map(cidade => cidade ? this._filterCidade(cidade) : this.listaCidade.slice())
      );
  }

  /*private _filterCidade(value: string): Cidade[] {
    const filterValue = value.toLowerCase();
    return this.listaCidade.filter(cidade => cidade.nome.toLowerCase().indexOf(filterValue) === 0);
  }*/

  /*listarCidades(): void {
    // carrega a lista de cidades
    this.cidadeService.findByNomeContaining(this.paciente.endereco.cidade).subscribe(data => {
      this.listaCidade = data;
    });
  }*/

  displayFn(cidade?: Cidade): string | undefined {
    return cidade ? cidade.nome : undefined;
  }

  private _filterCidade(nome: string): Cidade[] {
    const filterValue = nome.toLowerCase();
    return this.listaCidade.filter(option => option.nome.toLowerCase().indexOf(filterValue) === 0);
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

}
