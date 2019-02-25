import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class GetFavoritesService {

  //url = 'http://localhost:8080/TeamAwesomeProj2/proj2/ViewSavedWork';
  url = 'http://52.15.180.249:8080/proj2/proj2/ViewSavedWork';

  private httpOptions = {
    headers: new HttpHeaders({
      'ApiKey': '37dd07f19435cb72c14e0347ae4cc556e351d9503f0d39025011da7525fa83bb'
    })
  };

  private configUrl = 'https://api.art.rmngp.fr/v1/works/';

  constructor(private _http: HttpClient) { }

  send(username: string){
    console.log(username);
    let obs = this._http.post<any>(this.url, {username: username});
    return obs;
  }

  getImage(id: string){
    let obs = this._http.get<any>(this.configUrl + id, this.httpOptions);
    return obs;
  }
}
