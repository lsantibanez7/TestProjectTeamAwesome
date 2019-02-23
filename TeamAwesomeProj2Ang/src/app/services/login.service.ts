import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';

//import { LoginComponent } from './login';
@Injectable({
  providedIn: 'root'
})
export class LoginService {



  url = 'http://52.15.180.249:8080/proj2/proj2/login';

  // doLogin(login: Login){
  //   this.http.post<any>(this.url, login);
  // }

  
  constructor( private _http: HttpClient) { }
  send(username: string, password: string){
<<<<<<< HEAD
   let obs= this._http.post<any>(this.url,{username : username, password : password })
  .subscribe(data => {
    console.log(data)
    if(data == null){
      console.log("null object");
    }else{
      console.log("real object");
    }
  });

=======
    console.log("Hello: ", {username: username, password:password});
   let obs= this._http.post<any>(this.url,{username: username, password: password}).subscribe(data => {
     console.log(data);
   });
   console.log(obs);
>>>>>>> 4e2f45c1be3425e5db3927a4a0a584df288fcf57
   return obs;
   
    }
}
