export class RestRequest {
    username: string;
    bookId: number;
    datePickUp: Date;
    returnDate: Date;
   
    constructor(
        username: string,
        bookId: number,
        datePickUp: Date,
        returnDate: Date
    ) {
        this.username = username
        this.bookId = bookId
        this.datePickUp = datePickUp
        this.returnDate = returnDate
    }
}