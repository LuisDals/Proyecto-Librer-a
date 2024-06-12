import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Song } from 'src/app/auth/model/song.model';


@Injectable({
  providedIn: 'root'
})
export class SongServiceService {

  constructor(private http: HttpClient) { }

  public getAllSongs(): Observable<Song[]>{
    const url: string = "http://localhost:8080/auth/songs";
    return this.http.get<Song[]>(url);
  }

   public getSongFromSongName(songName: string): Observable<Song>{
    const url: string = "http://localhost:8080/auth/songs/" + songName;
    return this.http.get<Song>(url);
  } 

  public rateSong(songName: string, rating: number) : Observable<any> {
    return this.http.patch("http://localhost:8080/auth/songs/" + songName + "/rate/" + rating, {});
  }

  public playSong(songName: string): Observable<any> {
    return this.http.patch("http://localhost:8080/auth/songs/" + songName + "/play", {});
  }
}
