import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { GetFavoritesService } from 'src/app/services/get-favorites.service';
import { IfStmt } from '@angular/compiler';


@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {

  public zeroImage: any;
  public zeroTitle: String;
  public zeroCreator: String;
  public zeroPlace: string;
  public zeroCity: string;
  public zeroInfo: string;
  public zeroID: string;
  public zeroDate: string;
  public zeroBirth: string;

  public firstImage: any;
  public firstTitle: String;
  public firstCreator: String;
  public firstPlace: string;
  public firstCity: string;
  public firstInfo: string;
  public firstID: string;
  public firstDate: string;
  public firstBirth: string;

  public secondImage: any;
  public secondTitle: String;
  public secondCreator: String;
  public secondPlace: string;
  public secondCity: string;
  public secondInfo: string;
  public secondID: string;
  public secondDate: string;
  public secondBirth: string;

  public thirdImage: any;
  public thirdTitle: String;
  public thirdCreator: String;
  public thirdPlace: string;
  public thirdCity: string;
  public thirdInfo: string;
  public thirdID: string;
  public thirdDate: string;
  public thirdBirth: string;

  public fourthImage: any;
  public fourthTitle: String;
  public fourthCreator: String;
  public fourthPlace: string;
  public fourthCity: string;
  public fourthInfo: string;
  public fourthID: string;
  public fourthDate: string;
  public fourthBirth: string;

  public fifthImage: any;
  public fifthTitle: String;
  public fifthCreator: String;
  public fifthPlace: string;
  public fifthCity: string;
  public fifthInfo: string;
  public fifthID: string;
  public fifthDate: string;
  public fifthBirth: string;

  public sixImage: any;
  public sixTitle: String;
  public sixCreator: String;
  public sixPlace: string;
  public sixCity: string;
  public sixInfo: string;
  public sixID: string;
  public sixDate: string;
  public sixBirth: string;

  public sevenImage: any;
  public sevenTitle: String;
  public sevenCreator: String;
  public sevenPlace: string;
  public sevenCity: string;
  public sevenInfo: string
  public sevenID: string;
  public sevenDate: string;
  public sevenBirth: string;

  public eightImage: any;
  public eightTitle: String;
  public eightCreator: String;
  public eightPlace: string;
  public eightCity: string;
  public eightInfo: string;
  public eightID: string;
  public eightDate: string;
  public eightBirth: string;

  public nineImage: any;
  public nineTitle: String;
  public nineCreator: String;
  public ninePlace: string;
  public nineCity: string;
  public nineInfo: string;
  public nineID: string;
  public nineDate: string;
  public nineBirth: string;

  public length: number;

  public api_id: string;

  private Photos: Observable<any>;

  private Items: Observable<any>;

  public counter: number;

  constructor(private configService: GetFavoritesService) { }

  ngOnInit() {
    //This is the call to the API, bringing back
    this.Photos = this.configService.send(JSON.parse(localStorage.getItem("currentUser")).username);

    this.loadInfo();
  }
  // //not used
  // searchPlace(): any {
  //   if(this.selectedPlace == "Any"){
  //     this.Photos = this.configService.getConfig();
  //     this.loadInfo();
  //   }
  //   else if(this.selectedPlace != "Any"){
  //     console.log("Checking place");
  //  //   this.Photos = this.configService.getPlace(this.selectedPlace);
  //     this.loadInfo();
  //   }
  // }

  // //not used
  // searchPeople(): any {
    
  //   if(this.selectedArtist == "Any"){
  //     this.Photos = this.configService.getConfig();
  //     this.loadInfo();
  //   }
  //   else if (this.selectedArtist != "Any"){
  //     console.log("Checking info");
  //  //   this.Photos = this.configService.getArtist(this.selectedArtist);
  //     this.loadInfo();
  //   }
  // }


  loadInfo(): any {

    this.Photos.subscribe((data) => {
      this.length = data.length;
      this.counter = -1;
      console.log(this.length);
      while (this.length > 0){
        
        console.log("count",this.counter);
        this.Items = this.configService.getImage(data[this.length-1].apiId);  

      //Location area in the data will locate the city/possible museum
      //don't show images with ID 359813 and 257628
      this.Items.subscribe((items) => {
        console.log("things",items);
        if (items != null) {
          console.log("pickme",this.counter);
          this.counter++;
          if(this.counter == 0){
            console.log("zero");
          this.zeroDate = items.hits.hits[0]._source.date;
          if (this.zeroDate == undefined){
            this.zeroDate = "N/A";
          }
          else {
            this.zeroDate = items.hits.hits[0]._source.date.display;
          }
          this.zeroBirth = items.hits.hits[0]._source.authors;
          if (this.zeroBirth.length == 0){
            this.zeroBirth = "N/A";
          }
          else {
            this.zeroBirth = items.hits.hits[0]._source.authors[0].birth.display;
          }
          this.zeroImage = items.hits.hits[0]._source.images[0].urls.original;
          this.zeroTitle = items.hits.hits[0]._source.title;
          this.zeroID = items.hits.hits[0]._id;
          this.zeroPlace = items.hits.hits[0]._source.location.name.fr;
          this.zeroCity = items.hits.hits[0]._source.location.city;
          if(this.zeroCity == undefined){
            this.zeroCity = "N/A";
          }
          else {
            this.zeroCity = items.hits.hits[0]._source.location.city.en;
          }
          this.zeroInfo = items.hits.hits[0]._source.location.website;
          if(this.zeroInfo == undefined){
            this.zeroInfo = "N/A";
          }
          else {
            this.zeroInfo = this.zeroInfo = items.hits.hits[0]._source.location.website;
          }
          if (this.zeroTitle == undefined) {
            this.zeroTitle = "Anonymous";
          }
          else {
            this.zeroTitle = items.hits.hits[0]._source.title.en;
            if(this.zeroTitle == undefined){
              this.zeroTitle = items.hits.hits[0]._source.title.fr;
            }
          }
          this.zeroCreator = items.hits.hits[0]._source.authors[0];
          if (this.zeroCreator == undefined){
            this.zeroCreator = "Anonymous";
          }
          else {
            this.zeroCreator = items.hits.hits[0]._source.authors[0].name.en;
          }
        }
          //This will hide the info for the first logo photo
          //however, the html card div will still display
          // if(data.hits.hits[0]._id == 359813){
          //   this.zeroImage = "";
          //   this.zeroCreator = "";
          //   this.zeroTitle = "";
          // }
         else if(this.counter == 1){
           console.log("one");
          this.firstDate = items.hits.hits[0]._source.date;
          if (this.firstDate == undefined){
            this.firstDate = "N/A";
          }
          else {
            this.firstDate = items.hits.hits[0]._source.date.display;
          }
          this.firstImage = items.hits.hits[0]._source.images[0].urls.original;
          this.firstTitle = items.hits.hits[0]._source.title;
          this.firstID = items.hits.hits[0]._id;
          this.firstPlace = items.hits.hits[0]._source.location.name.fr;
          this.firstCity = items.hits.hits[0]._source.location.city;
          if(this.firstCity == undefined){
            this.firstCity = "N/A";
          }
          else {
            this.firstCity = items.hits.hits[0]._source.location.city.en;
          }
          this.firstBirth = items.hits.hits[0]._source.authors;
          if (this.firstBirth.length == 0){
            this.firstBirth = "N/A";
          }
          else {
            this.firstBirth = items.hits.hits[0]._source.authors[0].birth.display;
          }
          this.firstInfo = items.hits.hits[0]._source.location.website;
          if(this.firstInfo == undefined){
            this.firstInfo = "N/A";
          }
          else {
            this.firstInfo = items.hits.hits[0]._source.location.website;
          }
          if (this.firstTitle == undefined) {
            this.firstTitle = "Anonymous";
          }
          else {
            this.firstTitle = items.hits.hits[0]._source.title.en;
            if(this.firstTitle == undefined){
              this.firstTitle = items.hits.hits[0]._source.title.fr;
            }
          }
          this.firstCreator = items.hits.hits[0]._source.authors[0];
          if (this.firstCreator == undefined){
            this.firstCreator = "Anonymous";
          }
          else {
            this.firstCreator = items.hits.hits[0]._source.authors[0].name.en;
          }
        }
        if(this.counter == 2){
          this.secondDate = items.hits.hits[0]._source.date;
          if (this.secondDate == undefined){
            this.secondDate = "N/A";
          }
          else {
            this.secondDate = items.hits.hits[0]._source.date.display;
          }
          this.secondImage = items.hits.hits[0]._source.images[0].urls.original;
          this.secondTitle = items.hits.hits[0]._source.title;
          this.secondBirth = items.hits.hits[0]._source.authors;
          if (this.secondBirth.length == 0){
            this.secondBirth = "N/A";
          }
          else {
            this.secondBirth = items.hits.hits[0]._source.authors[0].birth.display;
          }
          this.secondID = items.hits.hits[0]._id;
          this.secondPlace = items.hits.hits[0]._source.location.name.fr;
          this.secondCity = items.hits.hits[0]._source.location.city;
          if(this.secondCity == undefined){
            this.secondCity = "N/A";
          }
          else {
            this.secondCity = items.hits.hits[0]._source.location.city.en;
          }
          this.secondInfo = items.hits.hits[0]._source.location.website;
          if(this.secondInfo == undefined){
            this.secondInfo = "N/A";
          }
          else {
            this.secondInfo = items.hits.hits[0]._source.location.website;
          }
          if (this.secondTitle == undefined) {
            this.secondTitle = "Anonymous";
          }
          else {
            this.secondTitle = items.hits.hits[0]._source.title.en;
            if(this.secondTitle == undefined){
              this.secondTitle = items.hits.hits[0]._source.title.fr;
            }
          }
          this.secondCreator = items.hits.hits[0]._source.authors[0];
          if (this.secondCreator == undefined){
            this.secondCreator = "Anonymous";
          }
          else {
            this.secondCreator = items.hits.hits[0]._source.authors[0].name.en;
          }
        }
        else if(this.counter == 3){
          this.thirdDate = items.hits.hits[0]._source.date;
          if (this.thirdDate == undefined){
            this.thirdDate = "N/A";
          }
          else {
            this.thirdDate = items.hits.hits[0]._source.date.display;
          }
          this.thirdImage = items.hits.hits[0]._source.images[0].urls.original;
          this.thirdTitle = items.hits.hits[0]._source.title;
          this.thirdBirth = items.hits.hits[0]._source.authors;
          if (this.thirdBirth.length == 0){
            this.thirdBirth = "N/A";
          }
          else {
            this.thirdBirth = items.hits.hits[0]._source.authors[0].birth.display;
          }
          this.thirdID = items.hits.hits[0]._id;
          this.thirdPlace = items.hits.hits[0]._source.location.name.fr;
          this.thirdCity = items.hits.hits[0]._source.location.city;
          if(this.thirdCity == undefined){
            this.thirdCity = "N/A";
          }
          else {
            this.thirdCity = items.hits.hits[0]._source.location.city.en;
          }
          this.thirdInfo = items.hits.hits[0]._source.location.website;
          if(this.thirdInfo == undefined){
            this.thirdInfo = "N/A";
          }
          else {
            this.thirdInfo = items.hits.hits[0]._source.location.website;
          }
          if (this.thirdTitle == undefined) {
            this.thirdTitle = "Anonymous";
          }
          else {
            this.thirdTitle = items.hits.hits[0]._source.title.en;
            if(this.thirdTitle == undefined){
              this.thirdTitle = items.hits.hits[0]._source.title.fr;
            }
          }
          this.thirdCreator = items.hits.hits[0]._source.authors[0];
          if (this.thirdCreator == undefined){
            this.thirdCreator = "Anonymous";
          }
          else {
            this.thirdCreator = items.hits.hits[0]._source.authors[0].name.en;
          }
        }
        if(this.counter == 4){
          this.fourthDate = items.hits.hits[0]._source.date;
          if (this.fourthDate == undefined){
            this.fourthDate = "N/A";
          }
          else {
            this.fourthDate = items.hits.hits[0]._source.date.display;
          }
          this.fourthImage = items.hits.hits[0]._source.images[0].urls.original;
          this.fourthTitle = items.hits.hits[0]._source.title;
          this.fourthBirth = items.hits.hits[0]._source.authors;
          if (this.fourthBirth.length == 0){
            this.fourthBirth = "N/A";
          }
          else {
            this.fourthBirth = items.hits.hits[0]._source.authors[0].birth.display;
          }
          this.fourthID = items.hits.hits[0]._id;
          this.fourthPlace = items.hits.hits[0]._source.location.name.fr;
          this.fourthCity = items.hits.hits[0]._source.location.city;
          if(this.fourthCity == undefined){
            this.fourthCity = "N/A";
          }
          else {
            this.fourthCity = items.hits.hits[0]._source.location.city.en;
          }
          this.fourthInfo = items.hits.hits[0]._source.location.website;
          if(this.fourthInfo == undefined){
            this.fourthInfo = "N/A";
          }
          else {
            this.fourthInfo = items.hits.hits[0]._source.location.website;
          }
          if (this.fourthTitle == undefined) {
            this.fourthTitle = "Anonymous";
          }
          else {
            this.fourthTitle = items.hits.hits[0]._source.title.en;
            if(this.fourthTitle == undefined){
              this.fourthTitle = items.hits.hits[0]._source.title.fr;
            }
          }
          this.fourthCreator = items.hits.hits[0]._source.authors[0];
          if (this.fourthCreator == undefined){
            this.fourthCreator = "Anonymous";
          }
          else {
            this.fourthCreator = items.hits.hits[0]._source.authors[0].name.en;
          }
        }
        else if(this.counter == 5){
          this.fifthDate = items.hits.hits[0]._source.date;
          if (this.fifthDate == undefined){
            this.fifthDate = "N/A";
          }
          else {
            this.fifthDate = items.hits.hits[0]._source.date.display;
          }
          this.fifthImage = items.hits.hits[0]._source.images[0].urls.original;
          this.fifthTitle = items.hits.hits[0]._source.title;
          this.fifthBirth = items.hits.hits[0]._source.authors;
          if (this.fifthBirth.length == 0){
            this.fifthBirth = "N/A";
          }
          else {
            this.fifthBirth = items.hits.hits[0]._source.authors[0].birth.display;
          }
          this.fifthID = items.hits.hits[0]._id;
          this.fifthPlace = items.hits.hits[0]._source.location.name.fr;
          this.fifthCity = items.hits.hits[0]._source.location.city;
          if(this.fifthCity == undefined){
            this.fifthCity = "N/A";
          }
          else {
            this.fifthCity = items.hits.hits[0]._source.location.city.en;
          }
          this.fifthInfo = items.hits.hits[0]._source.location.website;
          if(this.fifthInfo == undefined){
            this.fifthInfo = "N/A";
          }
          else {
            this.fifthInfo = items.hits.hits[0]._source.location.website;
          }
          if (this.fifthTitle == undefined) {
            this.fifthTitle = "Anonymous";
          }
          else {
            this.fifthTitle = items.hits.hits[0]._source.title.en;
            if(this.fifthTitle == undefined){
              this.fifthTitle = items.hits.hits[0]._source.title.fr;
            }
          }
          this.fifthCreator = items.hits.hits[0]._source.authors[0];
          if (this.fifthCreator == undefined){
            this.fifthCreator = "Anonymous";
          }
          else {
            this.fifthCreator = items.hits.hits[0]._source.authors[0].name.en;
          }
        }
        else if(this.counter == 6){
          this.sixDate = items.hits.hits[0]._source.date;
          if (this.sixDate == undefined){
            this.sixDate = "N/A";
          }
          else {
            this.sixDate = items.hits.hits[0]._source.date.display;
          }
          this.sixImage = items.hits.hits[0]._source.images[0].urls.original;
          this.sixTitle = items.hits.hits[0]._source.title;
          this.sixBirth = items.hits.hits[0]._source.authors;
          if (this.sixBirth.length == 0){
            this.zeroBirth = "N/A";
          }
          else {
            this.sixBirth = items.hits.hits[0]._source.authors[0].birth.display;
          }
          this.sixID = items.hits.hits[0]._id;
          this.sixPlace = items.hits.hits[0]._source.location.name.fr;
          this.sixCity = items.hits.hits[0]._source.location.city;
          if(this.sixCity == undefined){
            this.sixCity = "N/A";
          }
          else {
            this.sixCity = items.hits.hits[0]._source.location.city.en;
          }
          this.sixInfo = items.hits.hits[0]._source.location.website;
          if(this.sixInfo == undefined){
            this.sixInfo = "N/A";
          }
          else {
            this.sixInfo = items.hits.hits[0]._source.location.website;
          }
          if (this.sixTitle == undefined) {
            this.sixTitle = "Anonymous";
          }
          else {
            this.sixTitle = items.hits.hits[0]._source.title.en;
            if(this.sixTitle == undefined){
              this.sixTitle = items.hits.hits[0]._source.title.fr;
            }
          }
          this.sixCreator = items.hits.hits[0]._source.authors[0];
          if (this.sixCreator == undefined){
            this.sixCreator = "Anonymous";
          }
          else {
            this.sixCreator = items.hits.hits[0]._source.authors[0].name.en;
          }
        }
        else if(this.counter == 7){
          this.sevenDate = items.hits.hits[0]._source.date;
          if (this.sevenDate == undefined){
            this.sevenDate = "N/A";
          }
          else {
            this.sevenDate = items.hits.hits[0]._source.date.display;
          }
          this.sevenImage = items.hits.hits[0]._source.images[0].urls.original;
          this.sevenTitle = items.hits.hits[0]._source.title;
          this.sevenBirth = items.hits.hits[0]._source.authors;
          if (this.sevenBirth.length == 0){
            this.sevenBirth = "N/A";
          }
          else {
            this.sevenBirth = items.hits.hits[0]._source.authors[0].birth.display;
          }
          this.sevenID = items.hits.hits[0]._id;
          this.sevenPlace = items.hits.hits[0]._source.location.name.fr;
          this.sevenCity = items.hits.hits[0]._source.location.city;
          if(this.sevenCity == undefined){
            this.sevenCity = "N/A";
          }
          else {
            this.sevenCity = items.hits.hits[0]._source.location.city.en;
          }
          this.sevenInfo = items.hits.hits[0]._source.location.website;
          if(this.sevenInfo == undefined){
            this.sevenInfo = "N/A";
          }
          else {
            this.sevenInfo = items.hits.hits[0]._source.location.website;
          }
          if (this.sevenTitle == undefined) {
            this.sevenTitle = "Anonymous";
          }
          else {
            this.sevenTitle = items.hits.hits[0]._source.title.en;
            if(this.sevenTitle == undefined){
              this.sevenTitle = items.hits.hits[0]._source.title.fr;
            }
          }
          this.sevenCreator = items.hits.hits[0]._source.authors[0];
          if (this.sevenCreator == undefined){
            this.sevenCreator = "Anonymous";
          }
          else {
            this.sevenCreator = items.hits.hits[0]._source.authors[0].name.en;
          }
        }
  
       else if(this.counter == 8){
          this.eightDate = items.hits.hits[0]._source.date;
          if (this.eightDate == undefined){
            this.eightDate = "N/A";
          }
          else {
            this.eightDate = items.hits.hits[0]._source.date.display;
          }
          this.eightImage = items.hits.hits[0]._source.images[0].urls.original;
          this.eightTitle = items.hits.hits[0]._source.title;
          this.eightID = items.hits.hits[0]._id;
          this.eightBirth = items.hits.hits[0]._source.authors;
          if (this.eightBirth.length == 0){
            this.eightBirth = "N/A";
          }
          else {
            this.eightBirth = items.hits.hits[0]._source.authors[0].birth.display;
          }
          this.eightPlace = items.hits.hits[0]._source.location.name.fr;
          this.eightCity = items.hits.hits[0]._source.location.city;
          if(this.eightCity == undefined){
            this.eightCity = "N/A";
          }
          else {
            this.eightCity = items.hits.hits[0]._source.location.city.en;
          }
          this.eightInfo = items.hits.hits[0]._source.location.website;
          if(this.eightInfo == undefined){
            this.eightInfo = "N/A";
          }
          else {
            this.eightInfo = items.hits.hits[0]._source.location.website;
          }
          if (this.eightTitle == undefined) {
            this.eightTitle = "Anonymous";
          }
          else {
            this.eightTitle = items.hits.hits[0]._source.title.en;
            if(this.eightTitle == undefined){
              this.eightTitle = items.hits.hits[0]._source.title.fr;
            }
          }
          this.eightCreator = items.hits.hits[0]._source.authors[0];
          if (this.eightCreator == undefined){
            this.eightCreator = "Anonymous";
          }
          else {
            this.eightCreator = items.hits.hits[0]._source.authors[0].name.en;
          }
        }
        else if(this.counter == 9){
          this.nineDate = items.hits.hits[0]._source.date;
          if (this.nineDate == undefined){
            this.nineDate = "N/A";
          }
          else {
            this.nineDate = items.hits.hits[0]._source.date.display;
          }
          this.nineImage = items.hits.hits[0]._source.images[0].urls.original;
          this.nineTitle = items.hits.hits[0]._source.title;
          this.nineBirth = items.hits.hits[0]._source.authors;
          if (this.nineBirth.length == 0){
            this.nineBirth = "N/A";
          }
          else {
            this.nineBirth = items.hits.hits[0]._source.authors[0].birth.display;
          }
          this.nineID = items.hits.hits[0]._id;
          this.ninePlace = items.hits.hits[0]._source.location.name.fr;
          this.nineCity = items.hits.hits[0]._source.location.city;
          if(this.nineCity == undefined){
            this.nineCity = "N/A";
          }
          else {
            this.nineCity = items.hits.hits[0]._source.location.city.en;
          }
          this.nineInfo = items.hits.hits[0]._source.location.website;
          if(this.nineInfo == undefined){
            this.nineInfo = "N/A";
          }
          else {
            this.nineInfo = items.hits.hits[0]._source.location.website;
          }
          if (this.nineTitle == undefined) {
            this.nineTitle = "Anonymous";
          }
          else {
            this.nineTitle = items.hits.hits[0]._source.title.en;
            if(this.nineTitle == undefined){
              this.nineTitle = items.hits.hits[0]._source.title.fr;
            }
          }
          this.nineCreator = items.hits.hits[0]._source.authors[0];
          if (this.nineCreator == undefined){
            this.nineCreator = "Anonymous";
          }
          else {
            this.nineCreator = items.hits.hits[0]._source.authors[0].name.en;
          }
        }
        //not here
      }
      //not here
      })
      this.length--;
    }
    //not here
    });
  }
}