import { Component, OnInit } from '@angular/core';
import { UserLogged } from 'src/app/user-logged';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

 // user = new UserLogged('','','');
  public userLoggedModel : any = {};

  constructor(private registrationService : RegistrationService) { }
  onSubmit() {
    this.registrationService.send( this.userLoggedModel.username, this.userLoggedModel.email, this.userLoggedModel.password)
      .subscribe(
        data => console.log('Success',data)
   
      )
  }

  ngOnInit() {
  }

}