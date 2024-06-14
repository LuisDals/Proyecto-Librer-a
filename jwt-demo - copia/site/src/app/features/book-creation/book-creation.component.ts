import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/auth/model/book.model';
import { BookService } from 'src/app/auth/service/book.service';

@Component({
  selector: 'app-book-creation',
  templateUrl: './book-creation.component.html',
  styleUrls: ['./book-creation.component.scss']
})
export class BookCreationComponent{
  book: Book = {
    bookName: '',
    author: '',
    genre: '',
    rentPrice: 0,
    salePrice:0,
    image: '',
    available: false
  };

  constructor(private bookService: BookService, private router: Router){

  }


  onSubmit(): void {
    this.bookService.createBook(this.book).subscribe({
      next: () => {
        alert('Book created successfully');
        this.router.navigate(['/books']);
      },
      error: (err) => {
        console.error('Error creating book:', err);
        alert('Error creating book');
      }
    });
  }

}
