import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { LoginService } from 'src/app/services/login.service'
import { User } from 'src/app/user';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']

})



export class LoginComponent implements OnInit {

  userModel = new User('','');

  constructor(private loginService: LoginService) {}
  onSubmit() {
    this.loginService.send( this.userModel)
      .subscribe(
        data => console.log('Success',data)
   
      )
  }
 ngOnInit() {
  }

}