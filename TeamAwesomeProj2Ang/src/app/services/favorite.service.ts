import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FavoriteService {

  //url = "http://52.15.180.249:8080/proj2/proj2/SaveArtwork";
  url = 'http://localhost:8080/TeamAwesomeProj2/proj2/SaveArtwork';

  constructor(private _http: HttpClient) { }

  send(id: string){
    let obs = this._http.post<any>(this.url, {id: id})
    .subscribe(data => {
      console.log("Id:",data);
    
    });
    return obs;
  }
}
