import { Component, OnInit } from '@angular/core';
import { BuscasService } from '../service/buscas.service';
import { Imc } from './imc-idade';


@Component({
  selector: 'app-imc-faixa-etaria',
  templateUrl: './imc-faixa-etaria.component.html',
  styleUrls: ['./imc-faixa-etaria.component.scss']
})
export class ImcFaixaEtariaComponent implements OnInit {

  listaIMC: Imc[] = [];
  lista: any[] = [];
  
  constructor(
    private service: BuscasService
  ) { }

  ngOnInit(): void {
    this.pesquisar();
  }

  async pesquisar(){

       const resp = await this.service.imcMedioPorFaixaEtaria();
    
       this.lista = resp.data;
       this.lista.map(x =>      
            this.listaIMC.push(new Imc(x[0], x[1]))
       );
  }

}
