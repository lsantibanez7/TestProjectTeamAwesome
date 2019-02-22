import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';

//import { LoginComponent } from './login';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

 

  url = 'http://52.15.180.249:8080/Project2/';


  
  constructor(private _http: HttpClient) { }
  send(username: string, password: string){
   let obs= this._http.post<any>(this.url,{username : username, password : password })
    .subscribe(data => {console.log(data)});

   return obs;
  }
}