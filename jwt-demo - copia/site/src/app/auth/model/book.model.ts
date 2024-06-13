import { BookRegister } from "./bookRegister.model";

export class Book {
    id: number;
    bookName: string;
    image: string;
    author: string;
    genre: string;
    publicationDate?: Date;
    rentPrice: number;
    salePrice: number;
    available: boolean;
    bookRegister?: BookRegister[];

    constructor(
        id: number,
        bookName: string,
        image: string,
        author: string,
        genre: string,
        rentPrice: number,
        salePrice: number,
        available: boolean,
        publicationDate?: Date,
        bookRegister?: BookRegister[]
    ) {
        this.id = id
        this.bookName = bookName
        this.image = image
        this.author = author
        this.genre = genre
        this.publicationDate = publicationDate
        this.rentPrice = rentPrice
        this.salePrice = salePrice
        this.available = available
        this.bookRegister = bookRegister
    }
}