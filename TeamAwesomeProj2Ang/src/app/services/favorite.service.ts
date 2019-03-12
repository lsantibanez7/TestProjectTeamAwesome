import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FavoriteService {

  url = "http://3.16.181.126:8080/proj2/proj2/SaveArtwork";
  //url = 'http://localhost:8080/TeamAwesomeProj2/proj2/SaveArtwork';

  constructor(private _http: HttpClient) { }

  send(username: string,apiId: string, comment: string){
    let obs = this._http.post<any>(this.url, {username: username, apiId: apiId, comment: comment})
    .subscribe(data => {
      console.log("Id:",data);
    
    });
    return obs;
  }
}
