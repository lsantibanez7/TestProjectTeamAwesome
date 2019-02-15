import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private httpOptions = {
    headers: new HttpHeaders({
      'ApiKey': '37dd07f19435cb72c14e0347ae4cc556e351d9503f0d39025011da7525fa83bb'
    })
  };

  //will need to change this, the default is page=1. 
  //but the value of page will have to be a variable that I can
  //either increment or decrement depending on a button click
  private configUrl = 'https://api.art.rmngp.fr/v1/works?page=3';

  constructor(private http: HttpClient) { }

  getConfig(){
    let obs = this.http.get(this.configUrl, this.httpOptions)
    return obs;
  }
}
