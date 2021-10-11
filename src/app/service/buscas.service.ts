import { Injectable } from '@angular/core';
import { Http } from './http-client';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class BuscasService {

  request = null;
  

  constructor(){ 

      let obj = {token: ""};
      let user = localStorage.getItem("user");
      if (typeof user === 'string') {
        obj = JSON.parse(user);
      }
      this.request = Http.httpClient(obj.token);

  }


  async candidatosPorEstado(){
      return this.request.get("/candidatosPorEstado");
  }

  async imcMedioPorFaixaEtaria(){
      return this.request.get("/imcMedioPorFaixaEtaria");
  }

  async percentualObesosPorSexo(){
      return this.request.get("/percentualObesosPorSexo");
  }

  async mediaIdadePorTipoSanguineo(){
      return this.request.get("/mediaIdadePorTipo");
  }

  async doadoresPorReceptor(){
      return this.request.get("/doadoresPorTipoReceptor");
  }


  signin(nome: string, pass: string){

      return this.request.post("/auth/signin", 
                    {username: nome,
                    password: pass
                    }   
                );
  }

  signup(nome: string, pass: string){

    return this.request.post("/auth/signup", 
                  {username: nome,
                  password: pass,
                  roles: ["USER"]
                  }   
              );
  }

}

