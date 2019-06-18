import { Ck } from './../../../../model/ck';
import { Ashworth } from './../../../../model/ashworth';
import { Adm } from './../../../../model/adm';
import { ForcaMuscular } from './../../../../model/forca-muscular';
import { Endereco } from './../../../../model/endereco';
import { MensagemComponent } from 'src/app/mensagem/mensagem.component';
import { Message } from './../../../../model/message';
import { MatDialog } from '@angular/material';
import { Mensagem } from './../../../paciente/form/cadastro-paciente/cadastro-paciente.component';
import { PacienteService } from './../../../../service/paciente.service';
import { Avaliacao } from './../../../../model/avaliacao';
import { Component, OnInit } from '@angular/core';
import {MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { Patologia } from 'src/app/model/patologia';
import { PatologiaService } from 'src/app/service/patologia.service';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-cadastro-avaliacao',
  templateUrl: './cadastro-avaliacao.component.html',
  styleUrls: ['./cadastro-avaliacao.component.css'],
  providers: [
    // The locale would typically be provided on the root module of your application. We do it at
    // the component level here, due to limitations of our example generation script.
    {provide: MAT_DATE_LOCALE, useValue: 'br-BR'},
    // `MomentDateAdapter` and `MAT_MOMENT_DATE_FORMATS` can be automatically provided by importing
    // `MatMomentDateModule` in your applications root module. We provide it at the component level
    // here, due to limitations of our example generation script.
    {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS}
  ],
})
export class CadastroAvaliacaoComponent implements OnInit {

  constructor(private pacienteService: PacienteService, private dialog: MatDialog, private _adapter: DateAdapter<any>,
    private patologiaService: PatologiaService) { }

  avaliacao: Avaliacao = new Avaliacao();

  listaPatologia: Patologia[] = [];

  listaHabitosVicios: string[] = ['Tabagista', 'Ex-Tabagista', 'Etilista', 'Ex-etilista'];

  descricaoEndereco: string;

  descricaoEstadoCivil: string;

  estadoCivilEnum: any = '{ "sigla": "DIV", "descricao" : "Divorciado" }, { "sigla" : "CAS", "descricao" : "Casado" }, { "sigla" : "SOL", "descricao" : "Solteiro" }';

  listaSinaisVitais: any[];

  listaNivelConsciencia: any[];

  listaEstadoEmocional: any[];

  listaSistemaRespiratorio: any[];

  listaRitmo: any[];

  listaPMRespiratorio: any[];

  listaExToracica: any[];

  listaAuscultaPulmonar: any[];

  listaRuidosAdventicios: any[];

  listaTosses: any[];

  listaSistemaOsteomioarticular: any[];

  listaForcaMuscular: any[];

  displayedColumnsForcaMuscular: string[] =  ['OMBRO', 'COTOVELO', 'PUNHO', 'TRONCO', 'QUADRIL', 'JOELHO', 'TORNOZELO'];

  dataSourceForcaMuscular: any[] = [];

  tamanhoArrayForcaMuscular = 7;

  dataSourceAvaliacaoADMMMS: Adm[] = [];

  dataSourceAvaliacaoADMMMII: Adm[] = [];

  displayedColumnsAvaliacaoADM: string[] =  ['articulação', 'flexão', 'flexão1', 'extensão', 'extensão1', 'abdução', 'abdução1', 'adução', 'adução1'];

  dataSourceEscalaAshworth: Ashworth[] = [];

  displayedColumnsAsworth: string[] = ['branco', 'normal', 'hipotonico', 'hipertonico', 'clonus'];

  listaAmplitudeArticular: Ck[] = [];

  listaTipoEmatomaAA: Ck[] = [];

  ngOnInit() {
    this.inicializarVariaveis();
  }

  inicializarVariaveis(): void {
    this.avaliacao = new Avaliacao();
    this.inicializar();
  }

  pesquisarPaciente() {
    if (this.avaliacao.paciente.cpf) {
      this.pacienteService.pesquisarPaciente(this.avaliacao.paciente).subscribe(data => {
        if (data) {
          this.avaliacao.paciente = data.items[0];
          this.descricaoEndereco = this.preencherEndereco();
          this.descricaoEstadoCivil = this.preencherEstadoCivil();
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

  preencherEndereco(): string {
    if (this.avaliacao.paciente.listaEndereco) {
      const endereco: Endereco = this.avaliacao.paciente.listaEndereco[0];
      if (endereco) {
        return endereco.descricaoEndereco + ' ' + endereco.cidade.nome + ' ' + endereco.cidade.estado.sgEstado;
      }
      return '';
    }
  }

  inicializar(): void {
    this.patologiaService.listarPatologias().subscribe(data => {
      this.listaPatologia = data;
    });
    this.listaSinaisVitais = JSON.parse('[' + '{ "sigla": "FC", "descricao" : "FC", "observacao": "" }, { "sigla" : "FR", "descricao" : "FR", "observacao": "" }, { "sigla" : "TAX", "descricao" : "TAX", "observacao": "" }, { "sigla" : "PA", "descricao" : "PA", "observacao": "" }' + ']');
    this.listaNivelConsciencia = JSON.parse('[' + '{ "sigla": "LUC", "descricao" : "lúcido-orientado" }, { "sigla": "DES", "descricao" : "desorientado" }, { "sigla": "LUCMD", "descricao" : "lúcido com momentos de desorientação" }, { "sigla": "INC", "descricao" : "inconsciente" }' + ']');
    this.listaEstadoEmocional = JSON.parse('[' + '{ "sigla": "CAL", "descricao" : "calmo" }, { "sigla": "AGIT", "descricao" : "agitado" }, { "sigla": "DEPRE", "descricao" : "depressivo" }, { "sigla": "ANC", "descricao" : "ancioso" }, { "sigla": "AGR", "descricao" : "agressivo" }' + ']');
    this.listaSistemaRespiratorio = JSON.parse('[' + '{ "sigla": "VE", "descricao" : "ventilação espontânea", "observacao": "" }, { "sigla": "VEO2", "descricao" : "ventilação espontânea com suporte de O2", "observacao" : "" }' + ']');
    this.listaRitmo = JSON.parse('[' + '{ "sigla": "REG", "descricao" : "regular" }, { "sigla": "TRAQ", "descricao" : "traqpinéia" }, { "sigla": "BRAD", "descricao" : "bradipnéia" }, { "sigla": "DISP", "descricao" : "dispnéia" }' + ']');
    this.listaPMRespiratorio = JSON.parse('[' + '{ "sigla": "DIAFR", "descricao" : "diafragmático" }, { "sigla": "CDIAFR", "descricao" : "costo-diafragmático" }, { "sigla": "INTC", "descricao" : "intercostal" }, { "sigla": "ACESS", "descricao" : "acessório" }, { "sigla": "PARAD", "descricao" : "paradoxal" }, { "sigla": "APIC", "descricao" : "apical" }' + ']');
    this.listaExToracica = JSON.parse('[' + '{ "sigla": "NORM", "descricao" : "normal" }, { "sigla": "DIMIN", "descricao" : "diminuída" }, { "sigla": "ASSIM", "descricao" : "assimétrica" }' + ']');
    this.listaAuscultaPulmonar = JSON.parse('[' + '{ "sigla": "MVSRA", "descricao" : "mv s/ra", "observacao": "" }, { "sigla" : "MVD", "descricao" : "mv diminuído", "observacao": "" }, { "sigla" : "MVA", "descricao" : "mv abolido", "observacao": "" }' + ']');
    this.listaRuidosAdventicios = JSON.parse('[' + '{ "sigla": "CREP", "descricao" : "crepitações" }, { "sigla": "RONC", "descricao" : "roncos" }, { "sigla": "SIBI", "descricao" : "sibilos" }' + ']');
    this.listaTosses = JSON.parse('[' + '{ "sigla": "AUS", "descricao" : "ausente" }, { "sigla": "SEC", "descricao" : "seca" }, { "sigla": "UMI", "descricao" : "úmida" }, { "sigla": "PROD", "descricao" : "produtiva" }' + ']');
    this.listaSistemaOsteomioarticular = JSON.parse('[' + '{ "sigla": "MOVV", "descricao" : "mov. voluntário" }, { "sigla": "MOVI", "descricao" : "mov. involutário" }, { "sigla": "PLEG", "descricao" : "plegia" }, { "sigla": "PARES", "descricao" : "paresia" }' + ']');
    this.listaForcaMuscular = JSON.parse('[' + '{ "sigla": "NORM", "descricao" : "normal" }, { "sigla": "DIMIN", "descricao" : "diminuída" }' + ']');
    this.inicializarDSForcaMuscular();
    this.inicializarDSAvaliacaoADM();
    this.inicializarEscalaAshworth();
    this.inicializarListaAmplitudeArticular();
    this.inicializarListaTipoEmatomaAA();
  }

  preencherEstadoCivil(): string {
    if (this.avaliacao.paciente.estadoCivil) {
      const array = JSON.parse('[' + this.estadoCivilEnum + ']');
      for (const item of array) {
        if (item.sigla === this.avaliacao.paciente.estadoCivil) {
          return item.descricao;
        }
      }
    }
    return '';
  }

  inicializarDSForcaMuscular(): void {
    for (let i = 0; i < this.tamanhoArrayForcaMuscular; i++) {
      this.dataSourceForcaMuscular.push(new ForcaMuscular());
    }
  }

  inicializarDSAvaliacaoADM(): void {
    const adm: Adm = new Adm();
    adm.descricao[1] = 'D';
    adm.descricao[2] = 'E';
    adm.descricao[3] = 'D';
    adm.descricao[4] = 'E';
    adm.descricao[5] = 'D';
    adm.descricao[6] = 'E';
    adm.descricao[7] = 'D';
    adm.descricao[8] = 'E';

    const admOmbro: Adm = new Adm();
    admOmbro.descricao[0] = 'ombro';
    const admCotovelo: Adm = new Adm();
    admCotovelo.descricao[0] = 'cotovelo';
    const admPunho: Adm = new Adm();
    admPunho.descricao[0] = 'punho';

    this.dataSourceAvaliacaoADMMMS.push(adm);
    this.dataSourceAvaliacaoADMMMS.push(admOmbro);
    this.dataSourceAvaliacaoADMMMS.push(admCotovelo);
    this.dataSourceAvaliacaoADMMMS.push(admPunho);

    const admQuadril: Adm = new Adm();
    admQuadril.descricao[0] = 'quadril';

    const admJoelho: Adm = new Adm();
    admJoelho.descricao[0] = 'joelho';
    admJoelho.descricao[5] = 'RI';
    admJoelho.descricao[7] = 'RE';

    const admMMIIBranco: Adm = new Adm();
    admMMIIBranco.descricao[1] = 'dorsiflexão';
    admMMIIBranco.descricao[3] = 'flexãoplanar';
    admMMIIBranco.descricao[5] = 'inversão';
    admMMIIBranco.descricao[7] = 'eversão';

    const admTornozelo: Adm = new Adm();
    admTornozelo.descricao[0] = 'tornozelo';

    this.dataSourceAvaliacaoADMMMII.push(adm);
    this.dataSourceAvaliacaoADMMMII.push(admQuadril);
    this.dataSourceAvaliacaoADMMMII.push(admJoelho);
    this.dataSourceAvaliacaoADMMMII.push(admMMIIBranco);
    this.dataSourceAvaliacaoADMMMII.push(admTornozelo);
  }

  inicializarEscalaAshworth(): void {
    const ashworth0: Ashworth = new Ashworth();
    ashworth0.descricao[0] = 'MS';
    const ashworth1: Ashworth = new Ashworth();
    ashworth1.descricao[0] = 'MI';

    this.dataSourceEscalaAshworth.push(ashworth0);
    this.dataSourceEscalaAshworth.push(ashworth1);
  }

  inicializarListaAmplitudeArticular(): void {
    const adm0: Ck = new Ck();
    adm0.titulo = 'normal';
    const adm1: Ck = new Ck();
    adm1.titulo = 'diminuída';

    this.listaAmplitudeArticular.push(adm0);
    this.listaAmplitudeArticular.push(adm1);
  }

  inicializarListaTipoEmatomaAA(): void {
    const tipoEAA: Ck = new Ck();
    tipoEAA.titulo = 'luxação';
    const tipoEAA1: Ck = new Ck();
    tipoEAA1.titulo = 'rigidez';
    const tipoEAA2: Ck = new Ck();
    tipoEAA2.titulo = 'fratura';
    const tipoEAA3: Ck = new Ck();
    tipoEAA3.titulo = 'desvios posturais';
    this.listaTipoEmatomaAA.push(tipoEAA);
    this.listaTipoEmatomaAA.push(tipoEAA1);
    this.listaTipoEmatomaAA.push(tipoEAA2);
    this.listaTipoEmatomaAA.push(tipoEAA3);
  }

}
