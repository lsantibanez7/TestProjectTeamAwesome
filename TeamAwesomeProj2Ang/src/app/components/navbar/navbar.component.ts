import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service'
import { User } from 'src/app/user';
import { ConfigService } from 'src/app/services/config.service'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  //userModel = new User('lauramrv1994@yahoo.com','password');


  public User : any = {};

  selectedArtist: string = "";

  selectedPlace: string = "";

  selectChangeHandler (event: any) {
    this.selectedArtist = event.target.value;
  }

  selectChangeHandler2 (event: any) {
    this.selectedPlace = event.target.value;
  }


  constructor(private loginService: LoginService) { }

  onPlace() {
    this.selectChangeHandler2(event);
    console.log("Testing place: " + this.selectedPlace);
  }

  onSubmit() {
    console.log(this.User);
    this.loginService.send(this.User.username, this.User.password)
  }

  ngOnInit() {
  }

}