import { CadastroPacienteComponent } from './cadastro/paciente/form/cadastro-paciente/cadastro-paciente.component';
import { PacienteComponent } from './cadastro/paciente/paciente.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'cadastro-paciente', component: PacienteComponent },
  { path: 'form-cadastro-paciente', component: CadastroPacienteComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
