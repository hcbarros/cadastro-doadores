
import axios from 'axios';


export class Http {

  static httpClient(token) {    
    return axios.create({
      baseURL: "http://localhost:8080/doadores",
      headers: {
        Authorization: `Bearer ${token}`,
      }
    });
  }

} 
