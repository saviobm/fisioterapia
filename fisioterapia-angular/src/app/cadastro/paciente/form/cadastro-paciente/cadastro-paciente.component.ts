import { Message } from './../../../../model/message';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Router } from '@angular/router';
import { Endereco } from './../../../../model/endereco';
import { map, startWith } from 'rxjs/operators';
import { Paciente } from './../../../../model/paciente';
import { Sexo } from './../../../../model/sexo';
import { PacienteService } from './../../../../service/paciente.service';
import { Cidade } from './../../../../model/cidade';
import { Component, OnInit, Inject } from '@angular/core';
import { NgForm, FormGroup, FormControl, FormsModule, NgControl } from '@angular/forms';
import { EnumService } from 'src/app/service/enum.service';
import { CidadeService } from 'src/app/service/cidade.service';
import { Observable } from 'rxjs';
import { MensagemComponent } from 'src/app/mensagem/mensagem.component';

export class Mensagem {
  titulo: string;
  mensagem: string;
}

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

  filteredOptions: Observable<Cidade[]>;

  public endereco: Endereco = new Endereco();

  myControl = new FormControl();

  listaSexo: Sexo[] = [ new Sexo('M', 'Masculino'), new Sexo('F', 'Feminino') ];

  constructor(private pacienteService: PacienteService, private enumService: EnumService, private cidadeService: CidadeService,
    private router: Router, public dialog: MatDialog) { }

  ngOnInit() {
    this.preencherCombos();
    this.filteredOptions = this.myControl.valueChanges
      .pipe(
        startWith<string | Cidade>(''),
        map(value => typeof value === 'string' ? value : value.nome),
        map(name => name ? this._filter(name) : this.listaCidade.slice())
      );
  }

  salvar(f: NgForm): void {
    this.paciente.listaEndereco.push(this.endereco);
    this.pacienteService.salvar(this.paciente).subscribe(data => {
      /*const mensagem: Mensagem = new Mensagem();
      mensagem.titulo = 'Teste';
      mensagem.mensagem = 'Paciente cadastrado com sucesso.';
      this.openDialog(mensagem);*/
      const message: Message = new Message();
      message.title = 'Mensagem de sucesso';
      message.message = 'Paciente cadastrado com sucesso.';
      this.openDialog(message);
    });
  }

  openDialog(message: Message): void {
    const dialogRef = this.dialog.open(MensagemComponent, {
      height: '400px',
      width: '600px',
      data: message
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.redirecionarPesquisaPaciente();
      }
    });
  }

  /*openDialog(mensagem: Mensagem): void {
    const dialogRef = this.dialog.open(MensagemComponent, {
      width: '250px',
      data : { titulo: mensagem.titulo, mensagem: mensagem.mensagem },
      mensagem : { mensagem }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });*/

  preencherCombos(): void {
    // carrega a lista de estado civil
    this.enumService.recuperarEnumsEstadoCivil().subscribe(data => {
      this.listaEstadoCivil = data;
    });

    // carrega a lista de cidades
    this.cidadeService.findAll().subscribe(data => {
      this.listaCidade = data;
    });
  }

  private _filter(value: string): Cidade[] {
    const filterValue = value.toLowerCase();
    return this.listaCidade.filter(option => option.nome.toLowerCase().includes(filterValue));
  }

  displayFn(cidade?: Cidade): string | undefined {
    return cidade ? cidade.nome : undefined;
  }

  redirecionarPesquisaPaciente(): void {
    this.router.navigate(['/cadastro-paciente']);
  }

  /*openDialog(mensagem: Mensagem): void {
    const dialogRef = this.dialog.open(MensagemComponent, {
      width: '250px',
      data: { titulo: mensagem.titulo, mensagem: mensagem.mensagem}
    });
    dialogRef.afterClosed().subscribe(result => {
      this.redirecionarPesquisaPaciente();
    });
  }*/



}
