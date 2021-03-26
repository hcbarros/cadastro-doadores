import { Component, OnInit } from '@angular/core';
import { BuscasService } from '../service/buscas.service';
import { Obeso } from './obeso';

@Component({
  selector: 'app-percentual-obesos-sexo',
  templateUrl: './percentual-obesos-sexo.component.html',
  styleUrls: ['./percentual-obesos-sexo.component.scss']
})
export class PercentualObesosSexoComponent implements OnInit {

  listaObesos: Obeso[] = [];
  lista: any[] = [];
  
  constructor(
    private service: BuscasService
  ) { }

  ngOnInit(): void {
    this.pesquisar();
  }

  async pesquisar(){

       const resp = await this.service.percentualObesosPorSexo();
    
       this.lista = resp.data;
       this.lista.map(x =>      
            this.listaObesos.push(new Obeso(x[0], x[1]))
       );
  }

}
