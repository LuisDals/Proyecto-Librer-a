export class Song {
    songName: string | undefined;
    image: string;
    style: string;
    artist: string;
    album: string;
    duration: string;
    rating?: number;
    /* playCount?:number; */

    constructor(
        songName: string | undefined,
        image: string,
        style: string,
        artist: string,
        album: string,
        duration: string,
        rating?: number/* ,
        playCount?:number */
    ) {
        this.songName = songName
        this.image = image
        this.style = style
        this.artist = artist
        this.album = album
        this.duration = duration
        this.rating = rating
        /* this.playCount = playCount */
    }
}