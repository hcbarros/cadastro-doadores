import { Component, OnInit } from '@angular/core';
import { Doadores } from './doadores';
import { BuscasService } from '../service/buscas.service';


@Component({
  selector: 'app-doadores-receptor',
  templateUrl: './doadores-receptor.component.html',
  styleUrls: ['./doadores-receptor.component.scss']
})
export class DoadoresReceptorComponent implements OnInit {

  listaDoadores: Doadores[] = [];
  lista: any[] = [];
  
  constructor(
    private service: BuscasService
  ) { }

  ngOnInit(): void {
    this.pesquisar();
  }

  async pesquisar(){

       const resp = await this.service.doadoresPorReceptor();
    
       this.lista = resp.data;
       this.lista.map(x =>      
            this.listaDoadores.push(new Doadores(x[0], x[1]))
       );
  }

}
