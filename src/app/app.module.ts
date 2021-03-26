import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import axios from 'axios';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './layout/layout.component';
import { BuscasService } from './service/buscas.service';
import { CandidatosEstadoComponent } from './candidatos-estado/candidatos-estado.component';
import { ImcFaixaEtariaComponent } from './imc-faixa-etaria/imc-faixa-etaria.component';
import { PercentualObesosSexoComponent } from './percentual-obesos-sexo/percentual-obesos-sexo.component';
import { IdadeTipoSanguineoComponent } from './idade-tipo-sanguineo/idade-tipo-sanguineo.component';
import { DoadoresReceptorComponent } from './doadores-receptor/doadores-receptor.component';
import { SigninComponent } from './auth/signin/signin.component';
import { SignupComponent } from './auth/signup/signup.component';


@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    CandidatosEstadoComponent,
    ImcFaixaEtariaComponent,
    PercentualObesosSexoComponent,
    IdadeTipoSanguineoComponent,
    DoadoresReceptorComponent,
    SigninComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [BuscasService],
  bootstrap: [AppComponent]
})
export class AppModule { }
