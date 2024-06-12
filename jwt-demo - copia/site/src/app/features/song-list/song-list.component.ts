import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SongServiceService } from '../../auth/service/song-service.service';
import { Song } from 'src/app/auth/model/song.model';

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.scss']
})
export class SongListComponent implements OnInit{
  
  username?: string;
  songList: Song[] = [];
  recentSongs: Song[] = [];
  isAuthenticated = false;

  constructor(private route: ActivatedRoute, private songService: SongServiceService){}

  ngOnInit(): void {
      this.getAllSongs();
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
