import { NgxMaskModule } from 'ngx-mask';
import { MensagemComponent } from './../../../../mensagem/mensagem.component';
import { Message } from './../../../../model/message';
import { Paciente } from './../../../../model/paciente';
import { Consulta } from './../../../../model/consulta';
import { Component, ViewChild, AfterViewInit, OnInit } from '@angular/core';
import { MatPaginator, MatSort, MatDialog, MatIconRegistry } from '@angular/material';
import {merge, Observable, of as observableOf} from 'rxjs';
import {catchError, map, startWith, switchMap} from 'rxjs/operators';
import { PacienteService } from 'src/app/service/paciente.service';
import { NgForm } from '@angular/forms';
import { Router, NavigationExtras } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-pesquisa-paciente',
  templateUrl: './pesquisa-paciente.component.html',
  styleUrls: ['./pesquisa-paciente.component.css']
})
export class PesquisaPacienteComponent implements AfterViewInit, OnInit {

  constructor(private pacienteService: PacienteService, private router: Router, public dialog: MatDialog, iconRegistry: MatIconRegistry, sanitizer: DomSanitizer) {
    iconRegistry.addSvgIcon(
      'fisioterapia-edit',
      sanitizer.bypassSecurityTrustResourceUrl('../../../../../assets/img/edit.gif'));
    iconRegistry.addSvgIcon(
      'fisioterapia-delete',
        sanitizer.bypassSecurityTrustResourceUrl('assets/img/close.gif'));
  }

  displayedColumns: string[] = ['cpf', 'nome', 'acao'];

  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;

  paciente: Paciente = new Paciente();

  listaPaciente: Paciente[] = [];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() { }

  ngAfterViewInit() {
    // If the user changes the sort order, reset back to the first page.
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          this.isLoadingResults = true;
          return this.pacienteService!.listarPacientes(this.sort.active, this.sort.direction, this.paginator.pageIndex);
        }),
        map(data => {
          // Flip flag to show that loading has finished.
          this.isLoadingResults = false;
          this.isRateLimitReached = false;
          this.resultsLength = data.totalCount;
          return data.items;
        }),
        catchError(() => {
          this.isLoadingResults = false;
          // Catch if the GitHub API has reached its rate limit. Return empty data.
          this.isRateLimitReached = true;
          return observableOf([]);
        })
      ).subscribe(data => this.listaPaciente = data);
  }

  getRowStyle(index) {
    return { background: index % 2 ? '#fafafa' : 'white' };
  }

  onSubmit(f: NgForm) {
    this.findByNomeContaining().subscribe(data => {
      this.preencherLista(data);
    });
  }

  findByNomeContaining(): Observable<Consulta> {
    return this.pacienteService.findByNomeContaining(this.paciente);
  }

  preencherLista(data: Consulta): void {
    this.isLoadingResults = false;
    this.isRateLimitReached = false;
    this.listaPaciente = data.items;
    this.resultsLength = data.totalCount;
  }

  editar(paciente: Paciente): void {
    const navigationExtras: NavigationExtras = {
      queryParams: {
        'paciente_id': paciente.id
      }
    };
    this.router.navigate(['/form-cadastro-paciente'], navigationExtras);
  }

  excluir(paciente: Paciente): void {
    this.pacienteService.excluir(paciente).subscribe(result => {
      if (result) {
        const message: Message = new Message();
        message.title = 'Exclusão';
        message.message = 'Paciente deletado com sucesso.';
        this.openDialog(message);
      }
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
        this.router.navigate(['/cadastro-paciente']);
      }
    });
  }

}
