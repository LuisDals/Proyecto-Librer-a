import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/user/login/login.component';
import { RegisterComponent } from './auth/user/register/register.component';
import { HelloComponent } from './features/hello/hello.component';
import { HomepageComponent } from './features/homepage/homepage.component';
import { SongListComponent } from './features/song-list/song-list.component';
import { SongDetailsComponent } from './features/song-details/song-details.component';
import { BookDetailsComponent } from './features/book-details/book-details.component';
import { BookListComponent } from './features/book-list/book-list.component';
import { UserProfileComponent } from './auth/user/user-profile/user-profile.component';
import { BookCreationComponent } from './features/book-creation/book-creation.component';
import { UpdateBookComponent } from './features/book-details/update-book/update-book.component';

const routes: Routes = [
  { path: '', redirectTo: '/homepage', pathMatch: 'full' },
  { path: 'homepage', component: HomepageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'hello', component: HelloComponent },
  { path: 'songList', component: SongListComponent },
  { path: 'songDetail/:songName', component: SongDetailsComponent },
  { path: 'bookDetail/:bookId', component: BookDetailsComponent},
  { path: 'bookList', component: BookListComponent}, 
  { path: 'user-profile/:username', component: UserProfileComponent},
  { path: 'createBook', component: BookCreationComponent},
  { path: 'bookUpdate/:bookId', component: UpdateBookComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
