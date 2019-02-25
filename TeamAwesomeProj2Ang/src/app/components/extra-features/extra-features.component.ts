import { Component, OnInit } from '@angular/core';
import { GoogleChartsModule } from 'angular-google-charts';

@Component({
  selector: 'app-extra-features',
  templateUrl: './extra-features.component.html',
  styleUrls: ['./extra-features.component.css']
})
export class ExtraFeaturesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  chart = {
    title: 'Amount of photos by Artist in the Digital Contemporary Arts Application',
    type: 'PieChart',
    data: [
      ['Gustave Moreau', 14418],
      ['Jean-Baptiste Carpeaux',4794],
      ['André-Adolphe-Eugène Disdéri',3747],
      ['Roland Bonaparte',4574],
      ['Léonard de Vinci',367],
    ],
    columnNames: ['Artist','Photos']
  
  }

}


// window.onload = function(){

// 	var data = [30, 86, 168, 281, 303, 365]; 
  
//   var d3: any;
  
// 	d3.select(".chart")
// 	  .selectAll("div")
// 	  .data(data)
// 	    .enter()
// 	    .append("div")
// 	    .style("width", function(d) {return d*2 + "px"; })
// 	    .text(function(d) {return d + " users this month";}); 
// } 
