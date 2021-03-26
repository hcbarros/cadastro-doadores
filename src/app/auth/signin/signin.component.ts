import { Component, OnInit } from '@angular/core';
import { BuscasService } from '../../service/buscas.service'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {

  username: string = '';
  password: string = '';
  
  constructor(
    private service: BuscasService,
    private router: Router
  ) { }

  ngOnInit(): void { }

  pesquisar(){

       this.service.signin(this.username, this.password)
           .then((response) => {
                
              if(response.data.token)
              localStorage.setItem("user", JSON.stringify(response.data));

              this.router.navigate(['/candidatos']);
           })
           .catch((error) =>  {
               alert("Acesso não autorizado!");
               console.log(error);
           }); 
       
  }

}
