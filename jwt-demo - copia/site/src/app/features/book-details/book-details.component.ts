import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/auth/model/book.model';
import { Users } from 'src/app/auth/model/user.model';
import { AuthService } from 'src/app/auth/service/auth.service';
import { BookService } from 'src/app/auth/service/book.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent implements OnInit {
  bookId: number;
  bookDetail?: Book;
  username: string = '';
  isAuthenticated = false;
  user?: Users;

  constructor(private bookService: BookService, private route: ActivatedRoute, private router: Router, private authService: AuthService, private http: HttpClient) {
    this.bookId = +this.route.snapshot.paramMap.get('bookId')!;
  }

  ngOnInit(): void {
    this.route.queryParamMap.subscribe(params => {
      this.username = params.get('user') ?? '';
      const token = this.authService.getToken();
      if (token) {
        this.isAuthenticated = true;
        this.http.get<any>(`http://localhost:8080/api/v1/user/${this.username}`, {
          headers: { Authorization: `Bearer ${token}` }
        }).subscribe({
          next: (data) => {
            console.log("Datos de usuario", data);
            this.user = data;
          },
          error: (error) => {
            console.error('Error getting user', error);
          }
        });
      }
    });
    this.getBookDetails();
  }

  getBookDetails(): void {
    this.bookService.getBookById(this.bookId.toString()).subscribe({
      next: (data) => this.bookDetail = data,
      error: (err) => console.error('Error fetching book details:', err)
    });
  }

  deleteBook() {
    if (confirm('Are you sure you want to delete this book?')) {
      this.bookService.deleteBook(this.bookId).subscribe({
        next: () => {
          alert('Book deleted successfully');
          this.router.navigate(['/bookList']);
        },
        error: (err) => console.error('Error deleting book:', err)
      });
    }
  }

  confirmDelete() {
    if (window.confirm('Are you sure you want to delete this book?')) {
      this.deleteBook();
    }
  }

  goToUpdateBook(): void {
    this.router.navigate(['/bookUpdate', this.bookId]);
  }
}
