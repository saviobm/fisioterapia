import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatMomentDateModule, MomentDateAdapter } from "@angular/material-moment-adapter";

import {NgxMaskModule, IConfig} from 'ngx-mask';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatSpinner, MatHeaderRowDef, MatRowDef, MatPaginator, MatTable, MatOption, MatFormField, MatPseudoCheckbox,
   MatProgressSpinnerModule, MatPaginatorModule, MatSortModule, MatTableModule, MatNativeDateModule } from '@angular/material';
import { CommonModule } from '@angular/common';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCheckboxModule} from '@angular/material';
import {MatButtonModule} from '@angular/material';
import {MatInputModule} from '@angular/material/input';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatSliderModule} from '@angular/material/slider';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatMenuModule} from '@angular/material/menu';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatStepperModule} from '@angular/material/stepper';
import {MatTabsModule} from '@angular/material/tabs';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { PesquisaPacienteComponent } from './cadastro/paciente/form/pesquisa-paciente/pesquisa-paciente.component';
import { CadastroPacienteComponent } from './cadastro/paciente/form/cadastro-paciente/cadastro-paciente.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MensagemComponent } from './mensagem/mensagem.component';
import { CadastroAvaliacaoComponent } from './cadastro/avaliacao/form/cadastro-avaliacao/cadastro-avaliacao.component';
import { PesquisaAvaliacaoComponent } from './cadastro/avaliacao/form/pesquisa-avaliacao/pesquisa-avaliacao.component';
import { MiniMentalComponent } from './cadastro/mini-mental/mini-mental.component';

export const options: Partial<IConfig> | (() => Partial<IConfig>) = null;

@NgModule({
  declarations: [
    AppComponent,
    PesquisaPacienteComponent,
    CadastroPacienteComponent,
    MensagemComponent,
    CadastroAvaliacaoComponent,
    PesquisaAvaliacaoComponent,
    MiniMentalComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    MatCheckboxModule,
    MatButtonModule,
    MatInputModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatStepperModule,
    MatTabsModule,
    MatExpansionModule,
    MatButtonToggleModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatDialogModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatDialogModule,
    MatMomentDateModule,
    NgxMaskModule.forRoot(options)
  ],
  entryComponents: [
    MensagemComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
