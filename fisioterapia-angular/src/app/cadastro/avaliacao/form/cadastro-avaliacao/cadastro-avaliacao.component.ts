import { AvaliacaoService } from './../../../../service/avaliacao.service';
import { Ponto } from './../../../../model/ponto';
import { Ck } from './../../../../model/ck';
import { Ashworth } from './../../../../model/ashworth';
import { Adm } from './../../../../model/adm';
import { ForcaMuscular } from './../../../../model/forca-muscular';
import { Endereco } from './../../../../model/endereco';
import { MensagemComponent } from 'src/app/mensagem/mensagem.component';
import { Message } from './../../../../model/message';
import { MatDialog, MatCheckbox } from '@angular/material';
import { Mensagem } from './../../../paciente/form/cadastro-paciente/cadastro-paciente.component';
import { PacienteService } from './../../../../service/paciente.service';
import { Avaliacao } from './../../../../model/avaliacao';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import {MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { PatologiaService } from 'src/app/service/patologia.service';
import {FormControl} from '@angular/forms';
import { template } from '@angular/core/src/render3';
import { controlNameBinding } from '@angular/forms/src/directives/reactive_directives/form_control_name';
import { Patologia } from './../../../../model/patologia';

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
    private patologiaService: PatologiaService, private avaliacaoService: AvaliacaoService) { }

  avaliacao: Avaliacao = new Avaliacao();

  listaPatologia: Patologia[] = [];

  listaHabitosVicios: Ck[] = [];

  descricaoEndereco: string;

  descricaoEstadoCivil: string;

  estadoCivilEnum: any = '{ "sigla": "DIV", "descricao" : "Divorciado" }, { "sigla" : "CAS", "descricao" : "Casado" }, { "sigla" : "SOL", "descricao" : "Solteiro" }';

  listaSinaisVitais: Ck[] = [];

  listaNivelConsciencia: Ck[] = [];

  listaEstadoEmocional: Ck[] = [];

  listaSistemaRespiratorio: Ck[] = [];

  listaRitmo: any[];

  listaPMRespiratorio: any[];

  listaExToracica: any[];

  listaAuscultaPulmonar: any[];

  listaRuidosAdventicios: any[];

  listaTosses: any[];

  listaSistemaOsteomioarticular: any[];

  listaForcaMuscular: any[];

  displayedColumnsForcaMuscular: string[] =  ['OMBRO', 'COTOVELO', 'PUNHO', 'TRONCO', 'QUADRIL', 'JOELHO', 'TORNOZELO'];

  displayedColumnsOsteotendinoso: string[] =  ['branco', 'normoreflexia', 'hiporeflexia', 'hiperreflexia', 'arreflexia'];

  dataSourceForcaMuscular: any[] = [];

  dataSourceOsteotendinoso: Ck[] = [];

  tamanhoArrayForcaMuscular = 7;

  dataSourceAvaliacaoADMMMS: Adm[] = [];

  dataSourceAvaliacaoADMMMII: Adm[] = [];

  displayedColumnsAvaliacaoADM: string[] =  ['articulação', 'flexão', 'flexão1', 'extensão', 'extensão1', 'abdução', 'abdução1', 'adução', 'adução1'];

  dataSourceEscalaAshworth: Ashworth[] = [];

  displayedColumnsAsworth: string[] = ['branco', 'normal', 'hipotonico', 'hipertonico', 'clonus'];

  displayedColumnsCoordenacao: string[] = ['coordenacao', 'branco'];

  displayedColumnsEquilibrio: string[] = ['equilibrio', 'branco'];

  listaAmplitudeArticular: Ck[] = [];

  listaTipoEmatomaAA: Ck[] = [];

  listaDeambulacao: Ck[] = [];

  listaMarcha: Ck[] = [];

  listaSensibilidade: Ck[] = [];

  dataSourceCoordenacao: Adm[] = [];

  dataSourceEquilibrio: Adm[] = [];

  listaTipoDores: Ck[] = [];

  listaPontos: Ponto[] = [];

  listaAparelhosDigestorio: Ck[] = [];

  listaAbdomem: Ck[] = [];

  listaAparelhoGenitourinario: Ck[] = [];

  @ViewChild('canvas')
  canvas: ElementRef<HTMLCanvasElement>;

  private ctx: CanvasRenderingContext2D;
  private img = new Image(453, 325);

  ngOnInit() {
    this.inicializarVariaveis();
    this.img.src = './assets/img/corpo_humano.jpg';
    this.img.onload = this.inicializarCanva.bind(this);
  }

  inicializarCanva():void {
    this.canvas.nativeElement.width = this.img.width;
    this.canvas.nativeElement.height = this.img.height;

    this.ctx = this.canvas.nativeElement.getContext('2d');
    this.ctx.drawImage(this.img, 0, 0, this.img.width, this.img.height);
    // this.canvas.nativeElement.onmousemove = this.marcarPonto;
    this.canvas.nativeElement.onclick = e => this.marcarPonto(e);
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
    this.inicializarHabitosVicios();
    this.inicializarListaSinaisVitais();
    this.inicializarListaNivelConsciencia();
    this.inicializarListaEstadoEmocional();
    this.inicializarListaSistemaRespiratorio();
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
    this.inicializarListaDeambulacao();
    this.inicializarMarcha();
    this.inicializarSensibilidade();
    this.inicializarDatasourceCoordenacao();
    this.inicializarDatasourceEquilibrio();
    this.inicializarOsteotendinoso();
    this.inicializarListaTipoDores();
    this.inicializarListaAparelhosDigestorio();
    this.inicializarListaAbdomem();
    this.inicializarListaAparelhoGenitourinario();
  }

  inicializarListaSistemaRespiratorio(): void {
    const item: Ck = new Ck();
    item.titulo = 'ventilação espontânea';
    item.sigla[0] = 'VE';
    const item1: Ck = new Ck();
    item1.titulo = 'ventilação espontânea com suporte de O2';
    item1.sigla[0] = 'VEO2';
    this.listaSistemaRespiratorio.push(item);
    this.listaSistemaRespiratorio.push(item1);
  }

  inicializarListaEstadoEmocional(): void {
    const item: Ck = new Ck();
    item.titulo = 'calmo';
    item.sigla[0] = 'CAL';
    const item1: Ck = new Ck();
    item1.titulo = 'agitado';
    item1.sigla[0] = 'AGIT';
    const item2: Ck = new Ck();
    item2.titulo = 'depressivo';
    item2.sigla[0] = 'DEPRE';
    const item3: Ck = new Ck();
    item3.titulo = 'ancioso';
    item3.sigla[0] = 'ANC';
    const item4: Ck = new Ck();
    item4.titulo = 'agressivo';
    item4.sigla[0] = 'AGR';
    this.listaEstadoEmocional.push(item);
    this.listaEstadoEmocional.push(item1);
    this.listaEstadoEmocional.push(item2);
    this.listaEstadoEmocional.push(item3);
    this.listaEstadoEmocional.push(item4);
  }

  inicializarListaNivelConsciencia(): void {
    const item: Ck = new Ck();
    item.titulo = 'lúcido-orientado';
    item.sigla[0] = 'LUC';
    const item1: Ck = new Ck();
    item1.titulo = 'desorientado';
    item1.sigla[0] = 'DES';
    const item2: Ck = new Ck();
    item2.titulo = 'lúcido com momentos de desorientação';
    item2.sigla[0] = 'LUCMD';
    const item3: Ck = new Ck();
    item3.titulo = 'inconsciente';
    item3.sigla[0] = 'INC';
    this.listaNivelConsciencia.push(item);
    this.listaNivelConsciencia.push(item1);
    this.listaNivelConsciencia.push(item2);
    this.listaNivelConsciencia.push(item3);
  }

  inicializarListaSinaisVitais(): void {
    const item: Ck = new Ck();
    item.sigla[0] = 'FC';
    const item1: Ck = new Ck();
    item1.sigla[0] = 'FR';
    const item2: Ck = new Ck();
    item2.sigla[0] = 'TAX';
    const item3: Ck = new Ck();
    item3.sigla[0] = 'PA';
    this.listaSinaisVitais.push(item);
    this.listaSinaisVitais.push(item1);
    this.listaSinaisVitais.push(item2);
    this.listaSinaisVitais.push(item3);
  }

  inicializarHabitosVicios(): void {
    this.listaHabitosVicios = [
      {
        titulo: 'Tabagista',
        sigla: ['TAB']
      },
      {
        titulo: 'Ex-Tabagista',
        sigla: ['EXTAB']
      },
      {
        titulo: 'Etilista',
        sigla: ['ELIT']
      },
      {
        titulo: 'Ex-Etilista',
        sigla: ['EXELIT']
      }
    ];
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

  inicializarListaDeambulacao(): void {
    const deamb: Ck = new Ck();
    deamb.titulo = 'livre';
    const deamb1: Ck = new Ck();
    deamb1.titulo = 'bengala';
    const deamb2: Ck = new Ck();
    deamb2.titulo = 'andador';
    const deamb3: Ck = new Ck();
    deamb3.titulo = 'cadeira de rodas';
    const deamb4: Ck = new Ck();
    deamb4.titulo = 'leito';
    this.listaDeambulacao.push(deamb);
    this.listaDeambulacao.push(deamb1);
    this.listaDeambulacao.push(deamb2);
    this.listaDeambulacao.push(deamb3);
    this.listaDeambulacao.push(deamb4);
  }

  inicializarMarcha(): void {
    const marcha: Ck = new Ck();
    marcha.titulo = 'normal';
    const marcha1: Ck = new Ck();
    marcha1.titulo = 'antálgica';
    const marcha2: Ck = new Ck();
    marcha2.titulo = 'patológica';
    this.listaMarcha.push(marcha);
    this.listaMarcha.push(marcha1);
    this.listaMarcha.push(marcha2);
  }

  inicializarSensibilidade(): void {
    const sensibilidade: Ck = new Ck();
    sensibilidade.titulo = 'térmica';
    const sensibilidade1: Ck = new Ck();
    sensibilidade1.titulo = 'tátil';
    const sensibilidade2: Ck = new Ck();
    sensibilidade2.titulo = 'dolorosa';
    this.listaSensibilidade.push(sensibilidade);
    this.listaSensibilidade.push(sensibilidade1);
    this.listaSensibilidade.push(sensibilidade2);
  }

  inicializarDatasourceCoordenacao(): void {
    const item: Adm = new Adm();
    item.titulo = 'Index-Nariz';
    const item1: Adm = new Adm();
    item1.titulo = 'Index-Index';
    const item2: Adm = new Adm();
    item2.titulo = 'Calcanhar-Joelho';
    const item3: Adm = new Adm();
    item3.titulo = 'Disdiadococinesia';
    this.dataSourceCoordenacao.push(item);
    this.dataSourceCoordenacao.push(item1);
    this.dataSourceCoordenacao.push(item2);
    this.dataSourceCoordenacao.push(item3);
  }

  inicializarDatasourceEquilibrio(): void {
    const item: Adm = new Adm();
    item.titulo = 'Sentado';
    const item1: Adm = new Adm();
    item1.titulo = 'Romberg';
    const item2: Adm = new Adm();
    item2.titulo = 'Romberg Sensibilizado';
    const item3: Adm = new Adm();
    item3.titulo = 'Marcha';
    this.dataSourceEquilibrio.push(item);
    this.dataSourceEquilibrio.push(item1);
    this.dataSourceEquilibrio.push(item2);
    this.dataSourceEquilibrio.push(item3);
  }

  inicializarOsteotendinoso(): void {
    const item: Ck = new Ck();
    item.titulo = 'Bicital - C6';
    const item1: Ck = new Ck();
    item1.titulo = 'Triciptal - C7';
    const item2: Ck = new Ck();
    item2.titulo = 'Patelar - L2, L3 e L4';
    const item3: Ck = new Ck();
    item3.titulo = 'Aquileu - L5, S1 e S2';

    this.dataSourceOsteotendinoso.push(item);
    this.dataSourceOsteotendinoso.push(item1);
    this.dataSourceOsteotendinoso.push(item2);
    this.dataSourceOsteotendinoso.push(item3);
  }

  inicializarListaTipoDores(): void {
    const item: Ck = new Ck();
    item.titulo = 'Presente';
    const item1: Ck = new Ck();
    item1.titulo = 'Ausente';
    const item2: Ck = new Ck();
    item2.titulo = 'Mecânica';
    this.listaTipoDores.push(item);
    this.listaTipoDores.push(item1);
    this.listaTipoDores.push(item2);
  }

  marcarPonto(e: MouseEvent): any {
    if (!this.ctx.isPointInPath(e.offsetX, e.offsetY)) {
      this.adicionarPonto(e.offsetX, e.offsetY);
      console.log(this.ctx.isPointInStroke(e.offsetX, e.offsetY));
      console.log(e);
      this.ctx.beginPath();
      this.ctx.fillStyle = 'red';
      this.ctx.strokeStyle = '#df4b26';
      this.ctx.arc(e.offsetX, e.offsetY, 6, 0, 2 * Math.PI);
      this.ctx.stroke();
      this.ctx.fill();
    }
  }

  adicionarPonto(x: number, y: number): void {
    const ponto: Ponto = new Ponto();
    ponto.x = x;
    ponto.y = y;
    this.listaPontos.push(ponto);
    console.log(this.listaPontos);
  }

  limparCanvas(): void {
    this.listaPontos = [];
    this.img.src = './assets/img/corpo_humano.jpg';
    this.img.onload = this.inicializarCanva.bind(this);
  }

  inicializarListaAparelhosDigestorio(): void {
    const item: Ck = new Ck();
    item.titulo = 'continência';
    const item1: Ck = new Ck();
    item1.titulo = 'incontinência fecal';
    const item2: Ck = new Ck();
    item2.titulo = 'obstipação';
    this.listaAparelhosDigestorio.push(item);
    this.listaAparelhosDigestorio.push(item1);
    this.listaAparelhosDigestorio.push(item2);
  }

  inicializarListaAbdomem(): void {
    const item: Ck = new Ck();
    item.titulo = 'normal';
    const item1: Ck = new Ck();
    item1.titulo = 'rígido';
    const item2: Ck = new Ck();
    item2.titulo = 'flácido';
    const item3: Ck = new Ck();
    item3.titulo = 'distendido';
    const item4: Ck = new Ck();
    item4.titulo = 'doloroso';
    this.listaAbdomem.push(item);
    this.listaAbdomem.push(item1);
    this.listaAbdomem.push(item2);
    this.listaAbdomem.push(item3);
    this.listaAbdomem.push(item4);
  }

  inicializarListaAparelhoGenitourinario(): void {
    const item: Ck = new Ck();
    item.titulo = 'continência';
    const item1: Ck = new Ck();
    item1.titulo = 'função sexual';
    const item2: Ck = new Ck();
    item2.titulo = 'incontinência';
    this.listaAparelhoGenitourinario.push(item);
    this.listaAparelhoGenitourinario.push(item1);
    this.listaAparelhoGenitourinario.push(item2);
  }

  salvar() {
    this.avaliacao.listaHabitosVicios = this.listaHabitosVicios.filter(habito => habito.selecionado);
    // Filta a lista de sinais vitais para colocar apenas os selecionados
    this.avaliacao.listaSinaisVitais = this.listaSinaisVitais.filter(sinalVital => sinalVital.selecionado);
    this.avaliacao.listaNivelConsciencia = this.listaNivelConsciencia.filter(nivelConsciencia => nivelConsciencia.selecionado);
    this.avaliacao.listaEstadoEmocional = this.listaEstadoEmocional.filter(estadoEmocional => estadoEmocional.selecionado);
    this.avaliacao.listaSistemaRespiratorio = this.listaSistemaRespiratorio.filter(sistemaRespiratorio => sistemaRespiratorio.selecionado);
    this.avaliacaoService.salvar(this.avaliacao).subscribe(avaliacao => {
      const msg = new Message();
      if (avaliacao.id) {
        this.avaliacao = avaliacao;
        msg.message = 'Avaliação salva com sucesso!';
      } else {
        msg.message = 'Erro ao salvar a avaliação!';
      }
      msg.title = 'Cadastro Avaliação';
      this.openDialog(msg);
    });
  }

}
