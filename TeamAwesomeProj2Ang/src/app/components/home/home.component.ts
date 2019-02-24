import { Component, OnInit } from '@angular/core';
import { UserLogged } from 'src/app/user-logged';
import {RegistrationService} from 'src/app/services/registration.service';
import { Router } from '@angular/router';
import { GoogleChartsModule } from 'angular-google-charts';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 // userModelNew = new UserLogged('','','');
  
  public userModelNew: any = {};

  constructor(private _router: Router,private registrationService : RegistrationService) { }
  onSubmit() {
    this.registrationService.send( this.userModelNew.username, this.userModelNew.email, this.userModelNew.password);
  }

  onRegistration(){
    this._router.navigate(["/tempuserhome"]);
  }

  ngOnInit() {
    google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

  var data = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['Work',     11],
    ['Eat',      2],
    ['Commute',  2],
    ['Watch TV', 2],
    ['Sleep',    7]
  ]);

  var options = {
    title: 'My Daily Activities'
  };

  var chart = new google.visualization.PieChart(document.getElementById('piechart'));

  chart.draw(data, options);
}
  }

}

