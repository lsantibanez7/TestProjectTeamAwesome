import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewAllArtworksComponent } from './components/view-all-artworks/view-all-artworks.component';
import { LoginComponent } from './components/login/login.component';
import { ViewByArtistComponent } from './components/view-by-artist/view-by-artist.component';
import { ViewByMuseumComponent } from './components/view-by-museum/view-by-museum.component';
import { HomeComponent } from './components/home/home.component';
import { UserHomeComponent } from './components/user-home/user-home.component';



const routes: Routes = [
  {path:'', redirectTo: 'home', pathMatch:'full' },
  {path: 'home', component: HomeComponent},
  {path: 'viewall', component: ViewAllArtworksComponent},
  {path: 'login',component: LoginComponent},
  {path: 'viewartist', component:ViewByArtistComponent},
  {path:'viewmuseum', component:ViewByMuseumComponent},
  {path: 'tempuserhome', component: UserHomeComponent }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
