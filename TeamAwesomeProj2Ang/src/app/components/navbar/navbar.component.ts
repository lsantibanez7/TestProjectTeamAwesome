import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service'
import { User } from 'src/app/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  //userModel = new User('lauramrv1994@yahoo.com','password');


  public User : any = {};

  constructor(private loginService: LoginService) { }
  onSubmit() {
    console.log(this.User);
    this.loginService.send(this.User.username, this.User.password)
      .subscribe(
        data => console.log('Success',data)
   
      )
  }

  ngOnInit() {
  }

}