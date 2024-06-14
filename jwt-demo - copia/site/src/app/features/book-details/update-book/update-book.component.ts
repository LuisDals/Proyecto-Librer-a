import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/auth/model/book.model';
import { Users } from 'src/app/auth/model/user.model';
import { AuthService } from 'src/app/auth/service/auth.service';
import { BookService } from 'src/app/auth/service/book.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.scss']
})
export class UpdateBookComponent implements OnInit{
  bookId: number;
  book?: Book;
  username: string = '';
  isAuthenticated = false;
  user?: Users;

  constructor(private bookService: BookService, private route: ActivatedRoute, private router: Router, private authService: AuthService, private http: HttpClient) {
    this.bookId = +this.route.snapshot.paramMap.get('bookId')!;
  }
  ngOnInit(): void {
    this.getBookDetails();
  }

  getBookDetails(): void {
    this.bookService.getBookById(this.bookId.toString()).subscribe({
      next: (data) => this.book = data,
      error: (err) => console.error('Error fetching book details:', err)
    });
  }

  updateBook(): void {
    if (!this.book) return;

    this.bookService.updateBook(this.book).subscribe({
      next: (updatedBook) => {
        this.book = updatedBook;
        alert('Book updated successfully');
        this.router.navigate(['/bookList']);
      },
      error: (err) => console.error('Error updating book:', err)
    });
  }
}
