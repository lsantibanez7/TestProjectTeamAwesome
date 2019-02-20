import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';

//import { LoginComponent } from './login';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

 

  url = 'http://52.15.180.249:8080/Project2/login';
  // doLogin(login: Login){
  //   this.http.post<any>(this.url, login);
  // }

  
  constructor(private _http: HttpClient) { }
  send(user: User){
   let obs= this._http.post<any>(this.url,user);
   return obs;
  }
}
