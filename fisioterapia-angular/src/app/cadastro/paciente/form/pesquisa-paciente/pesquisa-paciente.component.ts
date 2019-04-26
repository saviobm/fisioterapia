import { Consulta } from './../../../../model/consulta';
import {HttpClient} from '@angular/common/http';
import {Component, ViewChild, AfterViewInit} from '@angular/core';
import {MatPaginator, MatSort} from '@angular/material';
import {merge, Observable, of as observableOf} from 'rxjs';
import {catchError, map, startWith, switchMap} from 'rxjs/operators';
import { PacienteService } from 'src/app/service/paciente.service';
import { Paciente } from 'src/app/model/paciente';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-pesquisa-paciente',
  templateUrl: './pesquisa-paciente.component.html',
  styleUrls: ['./pesquisa-paciente.component.css']
})
export class PesquisaPacienteComponent implements AfterViewInit {

  constructor(private pacienteService: PacienteService) { }

  displayedColumns: string[] = ['id', 'nome'];

  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;

  paciente: Paciente;

  listaPaciente: Paciente[] = [];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

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
    console.log(f.value);  // { first: '', last: '' }
    console.log(f.valid);  // false
    findByNomeContaining();
  }

  findByNomeContaining(): Promise<Consulta[]> {
    return fetch(this.pacienteService.listarPacientesFindByNomeContaining())
    .then(res => this.listaPaciente = res.json())
    .catch(err => {
       throw new Error(err.message);
     });
  }
}
