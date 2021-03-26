
import axios from 'axios';


export class Http {

  static httpClient() {    
    return axios.create({
      baseURL: "http://localhost:8080/doadores"
    });
  }

} 