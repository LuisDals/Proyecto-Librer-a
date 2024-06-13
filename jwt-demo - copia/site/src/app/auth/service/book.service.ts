import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../model/book.model';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { Users } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  public getAllBooks(): Observable<Book[]>{
    const url: string = "http://localhost:8080/auth/books/all";
    return this.http.get<Book[]>(url);
  }

  public getBookById(bookName: string): Observable<Book>{
    const url: string = "http://localhost:8080/auth/books/id/" + bookName;
    return this.http.get<Book>(url);
  }
  
  public getBooksByGenre(genre : string): Observable<Book>{
    const url: string = "http://localhost:8080/auth/books/genre/" + genre;
    return this.http.get<Book>(url);
  }

  public createBook(book: any): Observable<any> {
    return this.http.post(`http://localhost:8080/auth/books`, book);
  } 

  public updateUser(user: Users): Observable<Users> {
    const token = this.authService.getToken();
    let headers = new HttpHeaders();
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    const urlEndpoint: string = `http://localhost:8080/api/v1/user/update`;
    return this.http.patch<Users>(urlEndpoint, user, { headers });
  }

  public updateBook(book: Book): Observable<Book>{
    const urlEndpoint: string = `http://localhost:8080/auth/books/update`;
    /* const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    }); */
    return this.http.patch<Book>(urlEndpoint, book);
  }

  public deleteBook(bookId: number): Observable<void>{
    const urlEndpoint: string =  "http://localhost:8080/auth/books/delete/" + bookId;
    return this.http.delete<void>(urlEndpoint + bookId);
  }
}
