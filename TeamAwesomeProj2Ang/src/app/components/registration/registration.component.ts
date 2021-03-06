import { Component, OnInit } from '@angular/core';
import { UserLogged } from 'src/app/user-logged';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

 // userModelNew = new UserLogged('','','');
  public userLoggedModel : any = {};

  constructor(private registrationService : RegistrationService) { }
  onSubmit() {
    console.log(this.userLoggedModel);
    this.registrationService.send( this.userLoggedModel.username, this.userLoggedModel.email, this.userLoggedModel.password);
  }

  ngOnInit() {
  }

}