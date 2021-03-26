import { Component, OnInit } from '@angular/core';
import { BuscasService } from '../../service/buscas.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  username: string = '';
  password: string = '';
  
  constructor(
    private service: BuscasService,
    private router: Router
  ) { }

  ngOnInit(): void {  }

  cadastrar(){

        if(this.username.length < 6 || this.password.length < 6) {
          alert("Nome e senha devem ter no minimo 6 caracteres");
          return;
        }

       this.service.signup(this.username, this.password)
           .then((response) => {          

              alert(JSON.stringify(response.data.response));       
             
              this.router.navigate(['/']);  
           })
           .catch((error) =>  {
               console.log(error);
               alert("Tente outro nome de usuário ou novamente mais tarde!");
           }); 
       
  }

}
