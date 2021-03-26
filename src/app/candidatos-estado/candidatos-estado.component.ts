import { Component, OnInit } from '@angular/core';
import { BuscasService } from '../service/buscas.service'; 
import { Candidato } from './candidatos-estado';
 
@Component({
  selector: 'app-candidatos-estado',
  templateUrl: './candidatos-estado.component.html',
  styleUrls: ['./candidatos-estado.component.scss']
})
export class CandidatosEstadoComponent implements OnInit {

  candidatos: Candidato[] = [];
  lista: any[] = [];
  
  constructor(
    private service: BuscasService
  ) { }

  ngOnInit(): void {
    this.pesquisar();
  }

  async pesquisar(){

       const resp = await this.service.candidatosPorEstado();
    
       this.lista = resp.data;
       this.lista.map(x => 
            this.candidatos.push(new Candidato(x[0], x[1]))
       );
  }

}
