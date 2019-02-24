import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FavoriteService {

  //url = "http://52.15.180.249:8080/proj2/proj2/SaveArtwork";
  url = 'http://localhost:8080/TeamAwesomeProj2/proj2/SaveArtwork';

  constructor(private _http: HttpClient) { }

  send(username: string,api_id: string, comment: string){
    let obs = this._http.post<any>(this.url, {username: username, api_id: api_id, comment: comment})
    .subscribe(data => {
      console.log("Id:",data);
    
    });
    return obs;
  }
}
