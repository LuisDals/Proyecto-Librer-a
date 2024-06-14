import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookRegister } from '../model/bookRegister.model';

@Injectable({
  providedIn: 'root'
})
export class RentalService {
  private apiUrl = 'http://localhost:8080/auth';

  constructor(private http: HttpClient) { }

  getRentalsByUsername(username: string): Observable<BookRegister[]> {
    return this.http.get<BookRegister[]>(`${this.apiUrl}/book-registers/${username}`);
  }

  rentBook(username: string, bookId: number, datePickUp: Date, returnDate: Date): Observable<BookRegister> {
    const rentRequest = {
      username: username,
      bookId: bookId,
      datePickUp: datePickUp,
      returnDate: returnDate
    };
    return this.http.post<BookRegister>(`${this.apiUrl}/rent`, rentRequest);
  }
}
