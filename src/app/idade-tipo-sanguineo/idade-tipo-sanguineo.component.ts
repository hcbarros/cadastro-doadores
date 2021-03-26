import { Component, OnInit } from '@angular/core';
import { BuscasService } from '../service/buscas.service';
import { TipoIdade } from './idade-tipo-sanguineo';

@Component({
  selector: 'app-idade-tipo-sanguineo',
  templateUrl: './idade-tipo-sanguineo.component.html',
  styleUrls: ['./idade-tipo-sanguineo.component.scss']
})
export class IdadeTipoSanguineoComponent implements OnInit {

  listaTipo: TipoIdade[] = [];
  lista: any[] = [];
  
  constructor(
    private service: BuscasService
  ) { }

  ngOnInit(): void {
    this.pesquisar();
  }

  async pesquisar(){

       const resp = await this.service.mediaIdadePorTipoSanguineo();
    
       this.lista = resp.data;
       this.lista.map(x =>      
            this.listaTipo.push(new TipoIdade(x[0], x[1]))
       );
  }

}
