import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Song } from 'src/app/auth/model/song.model';
import { SongServiceService } from '../../auth/service/song-service.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-song-details',
  templateUrl: './song-details.component.html',
  styleUrls: ['./song-details.component.scss']
})
export class SongDetailsComponent implements OnInit {

  songName: string | undefined;
  comprobacion: string = "";
  songDetail?: Song;

  constructor(private route: ActivatedRoute, private songService: SongServiceService, private http: HttpClient) { }

  ngOnInit(): void {
    if (this.route.snapshot.paramMap.get("songName")) {
      this.songName = this.route.snapshot.paramMap.get("songName")!;
      this.comprobacion = "El nombre de la canción es: " + this.songName;
      this.getSongById(this.songName);
    } else {
      this.comprobacion = "No hay canción";
    }
  }


  getSongById(songName: string) {
    this.http.get<any>(`http://localhost:8080/auth/songs/${this.songName}`).subscribe((response) => {
      const body = response.body;
      console.log(body);
      this.songDetail = body;
      console.log(this.songName);
      });
  }

  rateSong(rating: number): void {
    if (this.songDetail) {
      this.songService.rateSong(this.songDetail.songName!, rating).subscribe(
        response => {
          console.log("Rating existoso: ", response);
          this.songDetail!.rating = rating;
        },
        error => {
          console.error("Error al calificar la canción: ", error);
        }
      );
    }
  }

  getAlbumImage(image: string): string {
    return 'data:image/jpeg;base64,' + image;
  }

  playSong(): void {
    if(this.songDetail){
      this.songService.playSong(this.songDetail.songName!).subscribe(
        response => {
          console.log("Reproducción existosa: ", response);
        },
        error => {
          console.error("Error al reproducir la canción: ", error);
        }
      );
    }
  }
}
