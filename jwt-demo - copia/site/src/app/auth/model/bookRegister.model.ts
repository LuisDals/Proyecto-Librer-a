export class BookRegister {
    id: number;
    userId: string;
    bookName: string;
    datePickUp: Date;
    returnDate: Date;
    priceWithDiscount: number;
    
    constructor(
        id: number,
        userId: string,
        bookName: string,
        datePickUp: Date,
        returnDate: Date,
        priceWithDiscount: number
    ) {
        this.id = id
        this.userId = userId
        this.bookName = bookName
        this.datePickUp = datePickUp
        this.returnDate = returnDate
        this.priceWithDiscount = priceWithDiscount
    }
}