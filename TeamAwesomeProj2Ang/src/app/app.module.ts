import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';

import { ViewAllArtworksComponent } from './components/view-all-artworks/view-all-artworks.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { PaginationComponent } from './components/pagination/pagination.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { ViewByArtistComponent } from './components/view-by-artist/view-by-artist.component';
import { ViewByMuseumComponent } from './components/view-by-museum/view-by-museum.component';
import { from } from 'rxjs';
import { LoggedNavbarComponent } from './components/logged-navbar/logged-navbar.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { UserHomeComponent } from './components/user-home/user-home.component';
import { GoogleChartsModule } from 'angular-google-charts';



@NgModule({
  declarations: [
    AppComponent,
    ViewAllArtworksComponent,
    LoginComponent,
    PaginationComponent,
    NavbarComponent,
    HomeComponent,
    ViewByArtistComponent,
    ViewByMuseumComponent,
    LoggedNavbarComponent,
    RegistrationComponent,
    UserHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    GoogleChartsModule.forRoot()



  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }