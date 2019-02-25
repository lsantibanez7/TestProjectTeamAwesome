import { Component, OnInit } from '@angular/core';
import * as d3 from 'd3';

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

window.onload = function(){

	var data = [30, 86, 168, 281, 303, 365]; 
  
  //var d3: any;
  
	d3.select(".chart")
	  .selectAll("div")
	  .data(data)
	    .enter()
	    .append("div")
	    .style("width", function(d) {return d*2 + "px"; })
	    .text(function(d) {return d + " users this month";}); 
} 