import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Users } from 'src/app/auth/model/user.model';
import { AuthService } from 'src/app/auth/service/auth.service';
import { SongServiceService } from '../../auth/service/song-service.service';
import { Song } from 'src/app/auth/model/song.model';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit{

  username: string = '';
  isAuthenticated = false;
  user?: Users; 
  songList: Song[] = [];
  recentSongs: Song[] = [];

  constructor(private authService : AuthService, private router : Router, private route: ActivatedRoute, private http: HttpClient, private songService: SongServiceService){
    this.username = this.route.snapshot.paramMap.get('username')!;
  }

  ngOnInit(): void {
        this.route.queryParamMap.subscribe(params => {
          this.username = params.get('username') ?? '';
          const token = this.authService.getToken();
          if(token){
            this.isAuthenticated = true;
            this.http.get<any>(`http://localhost:8080/api/v1/user/${this.username}`, {
              headers: { Authorization: `Bearer ${token}`}
            }).subscribe({
              next: (data) => {
                console.log("Datos de usuario" , data);
                this.user = data;
              },
              error: (error) => {
                console.error('Error getting user', error);
              }
            });
          }
        });
  }


  private getAllSongs(){
    this.songService.getAllSongs().subscribe({
      next: (songRequest) => {
        this.songList = songRequest;
        this.recentSongs = songRequest.slice(-5);
      }, 
      error: (error) => {
        console.log("Ha ocurrido un error en la llamada de las canciones " + error);
      }
    });
  }
  
 
}
