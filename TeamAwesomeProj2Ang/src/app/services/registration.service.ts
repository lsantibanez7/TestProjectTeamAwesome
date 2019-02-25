import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogged } from '../user-logged';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  url = 'http://52.15.180.249:8080/proj2/proj2/Register';
  //url = 'http://localhost:8080/TeamAwesomeProj2/proj2/Register';

  constructor(private _router: Router, private _http: HttpClient) { }
  send(username: string, email:string, password:string ){
    console.log(username);
    let obs= this._http.post<any>(this.url,{username: username, email:email, password:password})
    .subscribe(data => {
      console.log(data);
      if(data == null){
        console.error("Invalid registration");
      }
      else {
        localStorage.setItem("currentUser", JSON.stringify(data));
        console.log("LocalStorg", localStorage);
      }
    });
    return obs;
  }
}