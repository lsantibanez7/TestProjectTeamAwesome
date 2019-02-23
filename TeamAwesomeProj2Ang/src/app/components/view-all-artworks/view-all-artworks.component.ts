import { Component, OnInit } from '@angular/core';
import { ConfigService } from "src/app/services/config.service";
import { Observable } from 'rxjs';


@Component({
  selector: 'app-view-all-artworks',
  templateUrl: './view-all-artworks.component.html',
  styleUrls: ['./view-all-artworks.component.css']
})
export class ViewAllArtworksComponent implements OnInit {

  selectedArtist: string = "";

  selectedPlace: string = "";

  selectChangeHandler (event: any) {
    this.selectedArtist = event.target.value;
  }

  selectChangeHandler2(event: any){
    this.selectedPlace = event.target.value;
  }

  public isHidden: boolean;

  //museum = ['MusÃ©e du Louvre', 'Paris, musÃ©e du quai Branly - Jacques Chirac', 'musÃ©e d\'Orsay','Versailles, chÃ¢teaux de Versailles et de Trianon'];

  public person: string;
  public place: string;

  public zeroImage: any;
  public zeroTitle: String;
  public zeroCreator: String;
  public zeroPlace: string;
  public zeroCity: string;
  public zeroInfo: string;
  public zeroID: number;
  public zeroDate: string;
  public zeroBirth: string;

  public firstImage: any;
  public firstTitle: String;
  public firstCreator: String;
  public firstPlace: string;
  public firstCity: string;
  public firstInfo: string;
  public firstID: number;
  public firstDate: string;
  public firstBirth: string;

  public secondImage: any;
  public secondTitle: String;
  public secondCreator: String;
  public secondPlace: string;
  public secondCity: string;
  public secondInfo: string;
  public secondID: number;
  public secondDate: string;
  public secondBirth: string;

  public thirdImage: any;
  public thirdTitle: String;
  public thirdCreator: String;
  public thirdPlace: string;
  public thirdCity: string;
  public thirdInfo: string;
  public thirdID: number;
  public thirdDate: string;
  public thirdBirth: string;

  public fourthImage: any;
  public fourthTitle: String;
  public fourthCreator: String;
  public fourthPlace: string;
  public fourthCity: string;
  public fourthInfo: string;
  public fourthID: number;
  public fourthDate: string;
  public fourthBirth: string;

  public fifthImage: any;
  public fifthTitle: String;
  public fifthCreator: String;
  public fifthPlace: string;
  public fifthCity: string;
  public fifthInfo: string;
  public fifthID: number;
  public fifthDate: string;
  public fifthBirth: string;

  public sixImage: any;
  public sixTitle: String;
  public sixCreator: String;
  public sixPlace: string;
  public sixCity: string;
  public sixInfo: string;
  public sixID: number;
  public sixDate: string;
  public sixBirth: string;

  public sevenImage: any;
  public sevenTitle: String;
  public sevenCreator: String;
  public sevenPlace: string;
  public sevenCity: string;
  public sevenInfo: string
  public sevenID: number;
  public sevenDate: string;
  public sevenBirth: string;

  public eightImage: any;
  public eightTitle: String;
  public eightCreator: String;
  public eightPlace: string;
  public eightCity: string;
  public eightInfo: string;
  public eightID: number;
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

  private Photos: Observable<any>;

  constructor(private configService: ConfigService) { }

  ngOnInit() {
    //This is the call to the API, bringing back
    this.Photos = this.configService.getConfig();

    this.loadInfo();
  }

  //no longer used
  toggle(): void {
    this.isHidden = !this.isHidden;
  }

  nextPage(): any {
    //This is the call to the API, bringing back
    this.Photos = this.configService.upPage(this.selectedArtist, this.selectedPlace);

    this.loadInfo();

  }

  firstPage() : any {
    this.Photos = this.configService.pageOne(this.selectedArtist, this.selectedPlace);

    this.loadInfo();
  }

  secondPage() : any {
    this.Photos = this.configService.pageTwo(this.selectedArtist, this.selectedPlace);

    this.loadInfo();
  }

  thirdPage() : any {
    this.Photos = this.configService.pageThree(this.selectedArtist, this.selectedPlace);

    this.loadInfo();
  }

  prevPage() : any {

    this.Photos = this.configService.downPage(this.selectedArtist, this.selectedPlace);

    this.loadInfo();
  }

  searchItems(): any {
    if(this.selectedArtist == "Any" && this.selectedPlace == "Any"){
      this.Photos = this.configService.getConfig();
      this.loadInfo();
    }
    else if(this.selectedArtist != "Any" && this.selectedPlace == "Any"){
      this.Photos = this.configService.getArtist(this.selectedArtist);
      this.loadInfo();
    }
    else if(this.selectedArtist == "Any" && this.selectedPlace != "Any"){
      this.Photos = this.configService.getPlace(this.selectedPlace);
      this.loadInfo();
    }
    else if(this.selectedArtist != "Any" && this.selectedPlace != "Any"){
      try {
      this.Photos = this.configService.getItems(this.selectedPlace, this.selectedArtist);
      this.loadInfo();
      }
      catch(Exception){
        console.log("Could not find results");
      }
    }
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

      //Location area in the data will locate the city/possible museum
      //don't show images with ID 359813 and 257628
      console.log(data);
      if (data != null) {
        this.zeroDate = data.hits.hits[0]._source.date;
        if (this.zeroDate == undefined){
          this.zeroDate = "N/A";
        }
        else {
          this.zeroDate = data.hits.hits[0]._source.date.display;
        }
        this.zeroBirth = data.hits.hits[0]._source.authors;
        if (this.zeroBirth.length == 0){
          this.zeroBirth = "N/A";
        }
        else {
          this.zeroBirth = data.hits.hits[0]._source.authors[0].birth.display;
        }
        this.zeroImage = data.hits.hits[0]._source.images[0].urls.original;
        this.zeroTitle = data.hits.hits[0]._source.title;
        this.zeroID = data.hits.hits[0]._id;
        this.zeroPlace = data.hits.hits[0]._source.location.name.fr;
        this.zeroCity = data.hits.hits[0]._source.location.city;
        if(this.zeroCity == undefined){
          this.zeroCity = "N/A";
        }
        else {
          this.zeroCity = data.hits.hits[0]._source.location.city.en;
        }
        this.zeroInfo = data.hits.hits[0]._source.location.website;
        if(this.zeroInfo == undefined){
          this.zeroInfo = "N/A";
        }
        else {
          this.zeroInfo = this.zeroInfo = data.hits.hits[0]._source.location.website;
        }
        if (this.zeroTitle == undefined) {
          this.zeroTitle = "Anonymous";
        }
        else {
          this.zeroTitle = data.hits.hits[0]._source.title.en;
          if(this.zeroTitle == undefined){
            this.zeroTitle = data.hits.hits[0]._source.title.fr;
          }
        }
        this.zeroCreator = data.hits.hits[0]._source.authors[0];
        if (this.zeroCreator == undefined){
          this.zeroCreator = "Anonymous";
        }
        else {
          this.zeroCreator = data.hits.hits[0]._source.authors[0].name.en;
        }
        //This will hide the info for the first logo photo
        //however, the html card div will still display
        // if(data.hits.hits[0]._id == 359813){
        //   this.zeroImage = "";
        //   this.zeroCreator = "";
        //   this.zeroTitle = "";
        // }

        this.firstDate = data.hits.hits[1]._source.date;
        if (this.firstDate == undefined){
          this.firstDate = "N/A";
        }
        else {
          this.firstDate = data.hits.hits[1]._source.date.display;
        }
        this.firstImage = data.hits.hits[1]._source.images[0].urls.original;
        this.firstTitle = data.hits.hits[1]._source.title;
        this.firstID = data.hits.hits[1]._id;
        this.firstPlace = data.hits.hits[1]._source.location.name.fr;
        this.firstCity = data.hits.hits[1]._source.location.city;
        if(this.firstCity == undefined){
          this.firstCity = "N/A";
        }
        else {
          this.firstCity = data.hits.hits[1]._source.location.city.en;
        }
        this.firstBirth = data.hits.hits[1]._source.authors;
        if (this.firstBirth.length == 0){
          this.firstBirth = "N/A";
        }
        else {
          this.firstBirth = data.hits.hits[1]._source.authors[0].birth.display;
        }
        this.firstInfo = data.hits.hits[1]._source.location.website;
        if(this.firstInfo == undefined){
          this.firstInfo = "N/A";
        }
        else {
          this.firstInfo = data.hits.hits[1]._source.location.website;
        }
        if (this.firstTitle == undefined) {
          this.firstTitle = "Anonymous";
        }
        else {
          this.firstTitle = data.hits.hits[1]._source.title.en;
          if(this.firstTitle == undefined){
            this.firstTitle = data.hits.hits[1]._source.title.fr;
          }
        }
        this.firstCreator = data.hits.hits[1]._source.authors[0];
        if (this.firstCreator == undefined){
          this.firstCreator = "Anonymous";
        }
        else {
          this.firstCreator = data.hits.hits[1]._source.authors[0].name.en;
        }

        this.secondDate = data.hits.hits[2]._source.date;
        if (this.secondDate == undefined){
          this.secondDate = "N/A";
        }
        else {
          this.secondDate = data.hits.hits[2]._source.date.display;
        }
        this.secondImage = data.hits.hits[2]._source.images[0].urls.original;
        this.secondTitle = data.hits.hits[2]._source.title;
        this.secondBirth = data.hits.hits[2]._source.authors;
        if (this.secondBirth.length == 0){
          this.secondBirth = "N/A";
        }
        else {
          this.secondBirth = data.hits.hits[2]._source.authors[0].birth.display;
        }
        this.secondID = data.hits.hits[2]._id;
        this.secondPlace = data.hits.hits[2]._source.location.name.fr;
        this.secondCity = data.hits.hits[2]._source.location.city;
        if(this.secondCity == undefined){
          this.secondCity = "N/A";
        }
        else {
          this.secondCity = data.hits.hits[2]._source.location.city.en;
        }
        this.secondInfo = data.hits.hits[2]._source.location.website;
        if(this.secondInfo == undefined){
          this.secondInfo = "N/A";
        }
        else {
          this.secondInfo = data.hits.hits[2]._source.location.website;
        }
        if (this.secondTitle == undefined) {
          this.secondTitle = "Anonymous";
        }
        else {
          this.secondTitle = data.hits.hits[2]._source.title.en;
          if(this.secondTitle == undefined){
            this.secondTitle = data.hits.hits[2]._source.title.fr;
          }
        }
        this.secondCreator = data.hits.hits[2]._source.authors[0];
        if (this.secondCreator == undefined){
          this.secondCreator = "Anonymous";
        }
        else {
          this.secondCreator = data.hits.hits[2]._source.authors[0].name.en;
        }

        this.thirdDate = data.hits.hits[3]._source.date;
        if (this.thirdDate == undefined){
          this.thirdDate = "N/A";
        }
        else {
          this.thirdDate = data.hits.hits[3]._source.date.display;
        }
        this.thirdImage = data.hits.hits[3]._source.images[0].urls.original;
        this.thirdTitle = data.hits.hits[3]._source.title;
        this.thirdBirth = data.hits.hits[3]._source.authors;
        if (this.thirdBirth.length == 0){
          this.thirdBirth = "N/A";
        }
        else {
          this.thirdBirth = data.hits.hits[3]._source.authors[0].birth.display;
        }
        this.thirdID = data.hits.hits[3]._id;
        this.thirdPlace = data.hits.hits[3]._source.location.name.fr;
        this.thirdCity = data.hits.hits[3]._source.location.city;
        if(this.thirdCity == undefined){
          this.thirdCity = "N/A";
        }
        else {
          this.thirdCity = data.hits.hits[3]._source.location.city.en;
        }
        this.thirdInfo = data.hits.hits[3]._source.location.website;
        if(this.thirdInfo == undefined){
          this.thirdInfo = "N/A";
        }
        else {
          this.thirdInfo = data.hits.hits[3]._source.location.website;
        }
        if (this.thirdTitle == undefined) {
          this.thirdTitle = "Anonymous";
        }
        else {
          this.thirdTitle = data.hits.hits[3]._source.title.en;
          if(this.thirdTitle == undefined){
            this.thirdTitle = data.hits.hits[3]._source.title.fr;
          }
        }
        this.thirdCreator = data.hits.hits[3]._source.authors[0];
        if (this.thirdCreator == undefined){
          this.thirdCreator = "Anonymous";
        }
        else {
          this.thirdCreator = data.hits.hits[3]._source.authors[0].name.en;
        }

        this.fourthDate = data.hits.hits[4]._source.date;
        if (this.fourthDate == undefined){
          this.fourthDate = "N/A";
        }
        else {
          this.fourthDate = data.hits.hits[4]._source.date.display;
        }
        this.fourthImage = data.hits.hits[4]._source.images[0].urls.original;
        this.fourthTitle = data.hits.hits[4]._source.title;
        this.fourthBirth = data.hits.hits[4]._source.authors;
        if (this.fourthBirth.length == 0){
          this.fourthBirth = "N/A";
        }
        else {
          this.fourthBirth = data.hits.hits[4]._source.authors[0].birth.display;
        }
        this.fourthID = data.hits.hits[4]._id;
        this.fourthPlace = data.hits.hits[4]._source.location.name.fr;
        this.fourthCity = data.hits.hits[4]._source.location.city;
        if(this.fourthCity == undefined){
          this.fourthCity = "N/A";
        }
        else {
          this.fourthCity = data.hits.hits[4]._source.location.city.en;
        }
        this.fourthInfo = data.hits.hits[4]._source.location.website;
        if(this.fourthInfo == undefined){
          this.fourthInfo = "N/A";
        }
        else {
          this.fourthInfo = data.hits.hits[4]._source.location.website;
        }
        if (this.fourthTitle == undefined) {
          this.fourthTitle = "Anonymous";
        }
        else {
          this.fourthTitle = data.hits.hits[4]._source.title.en;
          if(this.fourthTitle == undefined){
            this.fourthTitle = data.hits.hits[4]._source.title.fr;
          }
        }
        this.fourthCreator = data.hits.hits[4]._source.authors[0];
        if (this.fourthCreator == undefined){
          this.fourthCreator = "Anonymous";
        }
        else {
          this.fourthCreator = data.hits.hits[4]._source.authors[0].name.en;
        }

        this.fifthDate = data.hits.hits[5]._source.date;
        if (this.fifthDate == undefined){
          this.fifthDate = "N/A";
        }
        else {
          this.fifthDate = data.hits.hits[5]._source.date.display;
        }
        this.fifthImage = data.hits.hits[5]._source.images[0].urls.original;
        this.fifthTitle = data.hits.hits[5]._source.title;
        this.fifthBirth = data.hits.hits[5]._source.authors;
        if (this.fifthBirth.length == 0){
          this.fifthBirth = "N/A";
        }
        else {
          this.fifthBirth = data.hits.hits[5]._source.authors[0].birth.display;
        }
        this.fifthID = data.hits.hits[5]._id;
        this.fifthPlace = data.hits.hits[5]._source.location.name.fr;
        this.fifthCity = data.hits.hits[5]._source.location.city;
        if(this.fifthCity == undefined){
          this.fifthCity = "N/A";
        }
        else {
          this.fifthCity = data.hits.hits[5]._source.location.city.en;
        }
        this.fifthInfo = data.hits.hits[5]._source.location.website;
        if(this.fifthInfo == undefined){
          this.fifthInfo = "N/A";
        }
        else {
          this.fifthInfo = data.hits.hits[5]._source.location.website;
        }
        if (this.fifthTitle == undefined) {
          this.fifthTitle = "Anonymous";
        }
        else {
          this.fifthTitle = data.hits.hits[5]._source.title.en;
          if(this.fifthTitle == undefined){
            this.fifthTitle = data.hits.hits[5]._source.title.fr;
          }
        }
        this.fifthCreator = data.hits.hits[5]._source.authors[0];
        if (this.fifthCreator == undefined){
          this.fifthCreator = "Anonymous";
        }
        else {
          this.fifthCreator = data.hits.hits[5]._source.authors[0].name.en;
        }

        this.sixDate = data.hits.hits[6]._source.date;
        if (this.sixDate == undefined){
          this.sixDate = "N/A";
        }
        else {
          this.sixDate = data.hits.hits[6]._source.date.display;
        }
        this.sixImage = data.hits.hits[6]._source.images[0].urls.original;
        this.sixTitle = data.hits.hits[6]._source.title;
        this.sixBirth = data.hits.hits[6]._source.authors;
        if (this.sixBirth.length == 0){
          this.zeroBirth = "N/A";
        }
        else {
          this.sixBirth = data.hits.hits[6]._source.authors[0].birth.display;
        }
        this.sixID = data.hits.hits[6]._id;
        this.sixPlace = data.hits.hits[6]._source.location.name.fr;
        this.sixCity = data.hits.hits[6]._source.location.city;
        if(this.sixCity == undefined){
          this.sixCity = "N/A";
        }
        else {
          this.sixCity = data.hits.hits[6]._source.location.city.en;
        }
        this.sixInfo = data.hits.hits[6]._source.location.website;
        if(this.sixInfo == undefined){
          this.sixInfo = "N/A";
        }
        else {
          this.sixInfo = data.hits.hits[6]._source.location.website;
        }
        if (this.sixTitle == undefined) {
          this.sixTitle = "Anonymous";
        }
        else {
          this.sixTitle = data.hits.hits[6]._source.title.en;
          if(this.sixTitle == undefined){
            this.sixTitle = data.hits.hits[6]._source.title.fr;
          }
        }
        this.sixCreator = data.hits.hits[6]._source.authors[0];
        if (this.sixCreator == undefined){
          this.sixCreator = "Anonymous";
        }
        else {
          this.sixCreator = data.hits.hits[6]._source.authors[0].name.en;
        }

        this.sevenDate = data.hits.hits[7]._source.date;
        if (this.sevenDate == undefined){
          this.sevenDate = "N/A";
        }
        else {
          this.sevenDate = data.hits.hits[7]._source.date.display;
        }
        this.sevenImage = data.hits.hits[7]._source.images[0].urls.original;
        this.sevenTitle = data.hits.hits[7]._source.title;
        this.sevenBirth = data.hits.hits[7]._source.authors;
        if (this.sevenBirth.length == 0){
          this.sevenBirth = "N/A";
        }
        else {
          this.sevenBirth = data.hits.hits[7]._source.authors[0].birth.display;
        }
        this.sevenID = data.hits.hits[7]._id;
        this.sevenPlace = data.hits.hits[7]._source.location.name.fr;
        this.sevenCity = data.hits.hits[7]._source.location.city;
        if(this.sevenCity == undefined){
          this.sevenCity = "N/A";
        }
        else {
          this.sevenCity = data.hits.hits[7]._source.location.city.en;
        }
        this.sevenInfo = data.hits.hits[7]._source.location.website;
        if(this.sevenInfo == undefined){
          this.sevenInfo = "N/A";
        }
        else {
          this.sevenInfo = data.hits.hits[7]._source.location.website;
        }
        if (this.sevenTitle == undefined) {
          this.sevenTitle = "Anonymous";
        }
        else {
          this.sevenTitle = data.hits.hits[7]._source.title.en;
          if(this.sevenTitle == undefined){
            this.sevenTitle = data.hits.hits[7]._source.title.fr;
          }
        }
        this.sevenCreator = data.hits.hits[7]._source.authors[0];
        if (this.sevenCreator == undefined){
          this.sevenCreator = "Anonymous";
        }
        else {
          this.sevenCreator = data.hits.hits[7]._source.authors[0].name.en;
        }

        this.eightDate = data.hits.hits[8]._source.date;
        if (this.eightDate == undefined){
          this.eightDate = "N/A";
        }
        else {
          this.eightDate = data.hits.hits[8]._source.date.display;
        }
        this.eightImage = data.hits.hits[8]._source.images[0].urls.original;
        this.eightTitle = data.hits.hits[8]._source.title;
        this.eightID = data.hits.hits[8]._id;
        this.eightBirth = data.hits.hits[8]._source.authors;
        if (this.eightBirth.length == 0){
          this.eightBirth = "N/A";
        }
        else {
          this.eightBirth = data.hits.hits[8]._source.authors[0].birth.display;
        }
        this.eightPlace = data.hits.hits[8]._source.location.name.fr;
        this.eightCity = data.hits.hits[8]._source.location.city;
        if(this.eightCity == undefined){
          this.eightCity = "N/A";
        }
        else {
          this.eightCity = data.hits.hits[8]._source.location.city.en;
        }
        this.eightInfo = data.hits.hits[8]._source.location.website;
        if(this.eightInfo == undefined){
          this.eightInfo = "N/A";
        }
        else {
          this.eightInfo = data.hits.hits[8]._source.location.website;
        }
        if (this.eightTitle == undefined) {
          this.eightTitle = "Anonymous";
        }
        else {
          this.eightTitle = data.hits.hits[8]._source.title.en;
          if(this.eightTitle == undefined){
            this.eightTitle = data.hits.hits[8]._source.title.fr;
          }
        }
        this.eightCreator = data.hits.hits[8]._source.authors[0];
        if (this.eightCreator == undefined){
          this.eightCreator = "Anonymous";
        }
        else {
          this.eightCreator = data.hits.hits[8]._source.authors[0].name.en;
        }

        this.nineDate = data.hits.hits[9]._source.date;
        if (this.nineDate == undefined){
          this.nineDate = "N/A";
        }
        else {
          this.nineDate = data.hits.hits[9]._source.date.display;
        }
        this.nineImage = data.hits.hits[9]._source.images[0].urls.original;
        this.nineTitle = data.hits.hits[9]._source.title;
        this.nineBirth = data.hits.hits[9]._source.authors;
        if (this.nineBirth.length == 0){
          this.nineBirth = "N/A";
        }
        else {
          this.nineBirth = data.hits.hits[9]._source.authors[0].birth.display;
        }
        this.nineID = data.hits.hits[9]._id;
        this.ninePlace = data.hits.hits[9]._source.location.name.fr;
        this.nineCity = data.hits.hits[9]._source.location.city;
        if(this.nineCity == undefined){
          this.nineCity = "N/A";
        }
        else {
          this.nineCity = data.hits.hits[9]._source.location.city.en;
        }
        this.nineInfo = data.hits.hits[9]._source.location.website;
        if(this.nineInfo == undefined){
          this.nineInfo = "N/A";
        }
        else {
          this.nineInfo = data.hits.hits[9]._source.location.website;
        }
        if (this.nineTitle == undefined) {
          this.nineTitle = "Anonymous";
        }
        else {
          this.nineTitle = data.hits.hits[9]._source.title.en;
          if(this.nineTitle == undefined){
            this.nineTitle = data.hits.hits[9]._source.title.fr;
          }
        }
        this.nineCreator = data.hits.hits[9]._source.authors[0];
        if (this.nineCreator == undefined){
          this.nineCreator = "Anonymous";
        }
        else {
          this.nineCreator = data.hits.hits[9]._source.authors[0].name.en;
        }
      }
    });
  }
}
