import { PesquisaAvaliacaoComponent } from './cadastro/avaliacao/form/pesquisa-avaliacao/pesquisa-avaliacao.component';
import { CadastroAvaliacaoComponent } from './cadastro/avaliacao/form/cadastro-avaliacao/cadastro-avaliacao.component';
import { CadastroPacienteComponent } from './cadastro/paciente/form/cadastro-paciente/cadastro-paciente.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PesquisaPacienteComponent } from './cadastro/paciente/form/pesquisa-paciente/pesquisa-paciente.component';

const routes: Routes = [
  { path: 'form-cadastro-paciente', component: CadastroPacienteComponent },
  { path: 'form-pesquisa-paciente', component: PesquisaPacienteComponent },
  { path: 'form-cadastro-avaliacao', component: CadastroAvaliacaoComponent },
  { path: 'form-pesquisa-avaliacao', component: PesquisaAvaliacaoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
