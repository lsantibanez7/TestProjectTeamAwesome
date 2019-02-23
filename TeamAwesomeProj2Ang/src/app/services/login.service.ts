import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';
import { RouterModule, Routes, Router } from '@angular/router';


//import { LoginComponent } from './login';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

 

  url = 'http://52.15.180.249:8080/proj2/proj2/login';
  //url = 'http://localhost:8080/TeamAwesomeProj2/proj2/login';


  
  constructor( private _router: Router, private _http: HttpClient) { }
  send(username: string, password: string){
   let obs = this._http.post<any>(this.url,{username : username, password : password })
  .subscribe(data => {
    console.log(data)
    if(data == null){
      console.error("null object");
    }else{
      //MADE BY MARIA
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
