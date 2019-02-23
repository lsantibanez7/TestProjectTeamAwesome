import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logged-navbar',
  templateUrl: './logged-navbar.component.html',
  styleUrls: ['./logged-navbar.component.css']
})
export class LoggedNavbarComponent implements OnInit {


  constructor(private _router: Router) { }

  onLogout() {
    console.log(localStorage);
    localStorage.clear();

    this._router.navigate(["/home"]);

    console.log("loggedout",localStorage);
  }

  ngOnInit() {
  }

}
