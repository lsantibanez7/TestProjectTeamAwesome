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

  public firstImage: any;
  public firstTitle: String;
  public firstCreator: String;

  public secondImage: any;
  public secondTitle: String;
  public secondCreator: String;

  public thirdImage: any;
  public thirdTitle: String;
  public thirdCreator: String;

  public fourthImage: any;
  public fourthTitle: String;
  public fourthCreator: String;

  public fifthImage: any;
  public fifthTitle: String;
  public fifthCreator: String;

  public sixImage: any;
  public sixTitle: String;
  public sixCreator: String;

  public sevenImage: any;
  public sevenTitle: String;
  public sevenCreator: String;

  public eightImage: any;
  public eightTitle: String;
  public eightCreator: String;

  public nineImage: any;
  public nineTitle: String;
  public nineCreator: String;

  private Photos: Observable<any>;

  constructor(private configService: ConfigService) { }

  ngOnInit() {
    //This is the call to the API, bringing back
    this.Photos = this.configService.getConfig();

    this.loadInfo();
  }

  toggle(): void {
    this.isHidden = !this.isHidden;
  }

  nextPage(): any {
    //This is the call to the API, bringing back
    this.Photos = this.configService.upPage(this.selectedArtist, this.selectedPlace);

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
        this.zeroImage = data.hits.hits[0]._source.images[0].urls.original;
        this.zeroTitle = data.hits.hits[0]._source.title;
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

        this.firstImage = data.hits.hits[1]._source.images[0].urls.original;
        this.firstTitle = data.hits.hits[1]._source.title;
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

        this.secondImage = data.hits.hits[2]._source.images[0].urls.original;
        this.secondTitle = data.hits.hits[2]._source.title;
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

        this.thirdImage = data.hits.hits[3]._source.images[0].urls.original;
        this.thirdTitle = data.hits.hits[3]._source.title;
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

        this.fourthImage = data.hits.hits[4]._source.images[0].urls.original;
        this.fourthTitle = data.hits.hits[4]._source.title;
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

        this.fifthImage = data.hits.hits[5]._source.images[0].urls.original;
        this.fifthTitle = data.hits.hits[5]._source.title;
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

        this.sixImage = data.hits.hits[6]._source.images[0].urls.original;
        this.sixTitle = data.hits.hits[6]._source.title;
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

        this.sevenImage = data.hits.hits[7]._source.images[0].urls.original;
        this.sevenTitle = data.hits.hits[7]._source.title;
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

        this.eightImage = data.hits.hits[8]._source.images[0].urls.original;
        this.eightTitle = data.hits.hits[8]._source.title;
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

        this.nineImage = data.hits.hits[9]._source.images[0].urls.original;
        this.nineTitle = data.hits.hits[9]._source.title;
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
