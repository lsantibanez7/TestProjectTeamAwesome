import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogged } from '../user-logged';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  url = 'http://52.15.180.249:8080/Project2/';

  constructor(private _http: HttpClient) { }
  send(userlogged: UserLogged ){
    let obs= this._http.post<any>(this.url,userlogged);
    return obs;
  }
}