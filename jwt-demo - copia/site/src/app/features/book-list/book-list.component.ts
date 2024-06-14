import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import jsPDF from 'jspdf';
import { Book } from 'src/app/auth/model/book.model';
import { Users } from 'src/app/auth/model/user.model';
import { AuthService } from 'src/app/auth/service/auth.service';
import { BookService } from 'src/app/auth/service/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit{
  username: string = '';
  isAuthenticated = false;
  user?: Users; 
  bookList: Book[] = [];

  page: number = 0;
  size: number = 10;
  sort: string = "";

  first: boolean = false;
  last: boolean = false;
  totalPages: number = 0;
  totalElements: number = 0;

  constructor(private bookService: BookService, private route: ActivatedRoute, private authService: AuthService, private http: HttpClient, private router: Router) { }
  ngOnInit(): void {
    this.getAllBooksPaged();
    this.route.queryParamMap.subscribe(params => {
      this.username = params.get('username') ?? '';
      const token = this.authService.getToken();
      if(token){
        this.isAuthenticated = true;
        this.http.get<any>(`http://localhost:8080/api/v1/user/${this.username}`, {
          headers: { Authorization: `Bearer ${token}`}
        }).subscribe({
          next: (data) => {
            console.log("Datos de usuario" , data);
            this.user = data;
          },
          error: (error) => {
            console.error('Error getting user', error);
          }
        });
      }
    });
  }

    printBookList() {
      const doc = new jsPDF();
  
      doc.setLineWidth(0.5);
      doc.rect(10, 10, doc.internal.pageSize.width - 20, doc.internal.pageSize.height - 20);
  
      const element = document.getElementById("bookList");
  
      // Obtener todos los elementos con clase 'card' dentro de '#bookList'
      const cards = element?.getElementsByClassName("card");
  
      let yOffset = 20; // Iniciar en una posición vertical adecuada
  
      // Iterar sobre cada tarjeta y agregar su contenido al PDF
      if (cards) {
          for (let i = 0; i < cards.length; i++) {
              const card = cards[i];
  
              // Obtener contenido específico de la tarjeta
              const bookName = card.querySelector('.card-title')?.textContent?.trim() || '';
              const publicationDate = card.querySelector('.publication-date')?.textContent?.trim() || '';
              const author = card.querySelector('.author')?.textContent?.trim() || '';
              const genre = card.querySelector('.genre')?.textContent?.trim() || '';
  
              // Agregar contenido de la tarjeta al PDF en formato de tabla
              doc.text(bookName, 20, yOffset);
              doc.text(publicationDate, 70, yOffset);
              doc.text(author, 120, yOffset);
              doc.text(genre, 170, yOffset);
  
              // Añadir espacio vertical para la próxima tarjeta
              yOffset += 10; // Ajusta este valor según sea necesario para el espaciado deseado
          }
      }
  
      doc.save('book-list.pdf');
  }

  getAllBooksPaged(){
    this.bookService.getAllBooksPaged(this.page, this.size, this.sort).subscribe({
      next: (data: any) => {
        this.bookList = data.content;
        this.first = data.first;
          this.last = data.last;
          this.totalPages = data.totalPages;
          this.totalElements = data.totalElements;
        console.log("Objeto", data.content);
      }, 
      error: (error) => {
        console.log("Ha ocurrido un error en la llamada de las canciones " + error);
      }
    });
  }

  nextPage() {
    this.page = this.page + 1;
    this.getAllBooksPaged();
  }
  previousPage() {
    this.page = this.page - 1;
    this.getAllBooksPaged();
  }

  goToBookDetail(bookId: number){
    const username = this.username;
    this.router.navigate(['/bookDetail', bookId], { queryParams:{ username }});
  }
}
