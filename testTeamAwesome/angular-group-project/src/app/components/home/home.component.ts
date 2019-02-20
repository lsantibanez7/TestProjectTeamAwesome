import { Component, OnInit } from '@angular/core';
import { UserLogged } from 'src/app/user-logged';
import {RegistrationService} from 'src/app/services/registration.service';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  userModelNew = new UserLogged('','','');
  
  constructor(private registrationService : RegistrationService) { }
  onSubmit() {
    this.registrationService.send( this.userModelNew)
      .subscribe(
        data => console.log('Success',data)
   
      )
  }

  ngOnInit() {
  }

}
