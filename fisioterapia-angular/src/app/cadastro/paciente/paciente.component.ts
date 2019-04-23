import { Observable } from 'rxjs';
import { PacienteService } from './../../service/paciente.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Paciente } from 'src/app/model/paciente';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.css']
})
export class PacienteComponent implements OnInit {

  constructor(private route: ActivatedRoute, private location: Location, private pacienteService: PacienteService) { }

  listaPaciente: Observable<Paciente[]>;

  ngOnInit() {
    this.listaPaciente = this.pacienteService.listarPacientes();
  }

}
