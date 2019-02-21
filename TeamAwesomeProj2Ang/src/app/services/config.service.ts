import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private pagePara: string = "page=";

  private pageNum : number = 1;

  private junkA: string = "&facets%5Bauthors%5D=";

  private junkL: string = "&facets%5Blocations%5D=";

  private httpOptions = {
    headers: new HttpHeaders({
      'ApiKey': '37dd07f19435cb72c14e0347ae4cc556e351d9503f0d39025011da7525fa83bb'
    })
  };

  private configUrl = 'https://api.art.rmngp.fr/v1/works?';

  constructor(private http: HttpClient) { }

  getConfig(){
    console.log("API call for all works");
    this.pageNum = 1;
    let obs = this.http.get(this.configUrl, this.httpOptions);
    return obs;
  }

  getItems(loc, person){
    console.log("Searching");
    this.pageNum = 1;
    if (loc == ""){
      loc = "Any";
    }
    if (person == ""){
      person = "Any";
    }
    switch(person){
      case "Any": 
        switch(loc){
          case "Any":
          let obs = this.http.get(this.configUrl + this.pagePara + this.pageNum, this.httpOptions);
          return obs;
          default:
          obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkL + loc, this.httpOptions);
          return obs;
        }
      default: 
        switch(loc){
          case "Any":
          let obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkA + person, this.httpOptions);
          return obs;
          default:
          obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkL + loc + this.junkA + person, this.httpOptions);
          return obs;
        }
    }

  }

  getPlace(loc){
    console.log("API for place");
    this.pageNum = 1;
    if(loc == ""){
      loc = "Any";
    }
    switch(loc){
      case "Any":
      let obs = this.http.get(this.configUrl + this.pagePara + this.pageNum, this.httpOptions);
      return obs;
      default:
      obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkL + loc, this.httpOptions);
      return obs;
    }
  }

  getArtist(person) {
    console.log("API for artist");
    this.pageNum = 1;
    if (person == ""){
      person = "Any";
    }
    switch(person){
      case "Any": 
      let obs = this.http.get(this.configUrl + this.pagePara + this.pageNum, this.httpOptions);
      return obs;
      default: 
      obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkA + person, this.httpOptions);
      return obs;
    }
  }

  upPage(person, place) {

    this.pageNum++;
    if (this.pageNum == 1001) {
      this.pageNum = 1;
    }
    if (person == ""){
      person = "Any";
    }
    if (place == ""){
      place = "Any";
    }
    console.log("API uppage call with page parameters");
    switch(person){
      case "Any": 
        switch(place){
          case "Any":
          let obs = this.http.get(this.configUrl + this.pagePara + this.pageNum, this.httpOptions);
          return obs;
          default:
          obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkL + place, this.httpOptions);
          return obs;
        }
      default: 
        switch(place){
          case "Any":
          let obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkA + person, this.httpOptions);
          return obs;
          default:
          obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkL + place + this.junkA + person, this.httpOptions);
          return obs;
        }
    }
  }

  downPage(person, place) {
    this.pageNum--;
    if (this.pageNum == 0){
      this.pageNum = 1000;
    }
    if (person == ""){
      person = "Any";
    }
    if (place == ""){
      place = "Any";
    }
    console.log("API downPage call with page parameters");
    switch(person){
      case "Any": 
        switch(place){
          case "Any":
          let obs = this.http.get(this.configUrl + this.pagePara + this.pageNum, this.httpOptions);
          return obs;
          default:
          obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkL + place, this.httpOptions);
          return obs;
        }
      default: 
        switch(place){
          case "Any":
          let obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkA + person, this.httpOptions);
          return obs;
          default:
          obs = this.http.get(this.configUrl + this.pagePara + this.pageNum + this.junkL + place + this.junkA + person, this.httpOptions);
          return obs;
        }
    }
  }
}
