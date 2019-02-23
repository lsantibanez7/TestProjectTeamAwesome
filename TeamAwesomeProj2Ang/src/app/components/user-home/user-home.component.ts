import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  constructor() { }

  //userName = "Not Maria";
  userName = JSON.parse(localStorage.getItem("currentUser")).username;

  ngOnInit() {
  }

}
