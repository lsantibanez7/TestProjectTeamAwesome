import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
//import { TestService } from './test.service';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Team Awesome Art Gallery';

  constructor (){

   //this.svc.printToConsole();
  }

  //calling the API on Init (when the page loads up)
  //I however do not want it on Init, I want it attached to a button 
  //click event, so maybe creating a component to handle the situation??
  ngOnInit(){
   // let obs = this.http.get(this._url, {headers : {ApiKey: this._key}})
   // obs.subscribe((response) => console.log(response));
  }
}

