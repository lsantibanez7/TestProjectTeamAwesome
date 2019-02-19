import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Lets not mess this up';

  items: Array<Object> = [];


constructor (){
  this.items = [
    { name: 'assets/images/flowers.jpg'},
    { name: 'assets/images/river.jpg'},
    { name: 'assets/images/road.jpg'}
  ];
}

ngOnInit(){

}

}
