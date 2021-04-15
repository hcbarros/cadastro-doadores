
import axios from 'axios';


export class Http {

  static httpClient() {    
    return axios.create({
      baseURL: "https://spring-doadores.herokuapp.com/doadores/"
    });
  }

} 