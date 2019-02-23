import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogged } from '../user-logged';
import { RouterModule, Routes, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  url = 'http://52.15.180.249:8080/proj2/proj2/Register';

  constructor(private _router: Router,private _http: HttpClient) { }
  send(username: string, email: string, password: string ){
    let obs= this._http.post<any>(this.url,{username: username, email:email, password: password})
    .subscribe(data => {
      console.log(data)
      if(data == null){
        console.error("null object");
      }else{
        console.log(data)
        //store active user
        localStorage.setItem("currentUser", JSON.stringify(data));
        //route to user home
        this._router.navigate(["/tempuserhome"])
      }
    });
    return obs;
  }
}
