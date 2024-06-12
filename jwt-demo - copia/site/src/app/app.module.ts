import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './auth/user/register/register.component';
import { LoginComponent } from './auth/user/login/login.component';
import { HelloComponent } from './features/hello/hello.component';
import { HeaderComponent } from './layouts/header/header.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { HomepageComponent } from './features/homepage/homepage.component';
import { SongListComponent } from './features/song-list/song-list.component';
import { SongDetailsComponent } from './features/song-details/song-details.component';
import { StarRatingComponent } from './features/song-details/star-rating/star-rating.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HelloComponent,
    HeaderComponent,
    FooterComponent,
    HomepageComponent,
    SongListComponent,
    SongDetailsComponent,
    StarRatingComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
