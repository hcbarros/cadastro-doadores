import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from './auth/signin/signin.component';
import { SignupComponent } from './auth/signup/signup.component';
import { CandidatosEstadoComponent } from './candidatos-estado/candidatos-estado.component';
import { DoadoresReceptorComponent } from './doadores-receptor/doadores-receptor.component';
import { IdadeTipoSanguineoComponent } from './idade-tipo-sanguineo/idade-tipo-sanguineo.component';
import { ImcFaixaEtariaComponent } from './imc-faixa-etaria/imc-faixa-etaria.component';
import { PercentualObesosSexoComponent } from './percentual-obesos-sexo/percentual-obesos-sexo.component';



const routes: Routes = [
  {
    path: '',
    component: SigninComponent,
    pathMatch: 'full'
  },
  {
    path: 'signup',
    component: SignupComponent,
    pathMatch: 'full'
  },  
  {
    path: 'candidatos',
    component: CandidatosEstadoComponent,
    pathMatch: 'full'
  },
  {
    path: 'imc',
    component: ImcFaixaEtariaComponent,
    pathMatch: 'full'
  },
  {
    path: 'obesos',
    component: PercentualObesosSexoComponent,
    pathMatch: 'full'
  },
  {
    path: 'idade-tipo',
    component: IdadeTipoSanguineoComponent,
    pathMatch: 'full'
  },
  {
    path: 'doadores',
    component: DoadoresReceptorComponent,
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
