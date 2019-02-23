import { Component, OnInit } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';


@Component({
  selector: 'app-logged-navbar',
  templateUrl: './logged-navbar.component.html',
  styleUrls: ['./logged-navbar.component.css']
})
export class LoggedNavbarComponent implements OnInit {

  constructor(private _router: Router) { }
  onLogout(){
    console.log (localStorage);
    //clears local Storage
    localStorage.clear();
    //route to home
    this._router.navigate(["/home"]);
    console.log (localStorage);

  }
  ngOnInit() {
  }

}
