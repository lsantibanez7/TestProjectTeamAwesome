import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogged } from '../user-logged';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  url = 'http://52.15.180.249:8080/proj2/proj2/Register';

  constructor(private _http: HttpClient) { }
  send(username: string, email: string, password: string ){
    let obs= this._http.post<any>(this.url,{username: username, email:email, password: password});
    return obs;
  }
}
