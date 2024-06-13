import { Component } from '@angular/core';
import jsPDF from 'jspdf';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent {

  constructor() { }

  printBookList() {
    const doc = new jsPDF();

    doc.setLineWidth(0.5);
    doc.rect(10, 10, doc.internal.pageSize.width - 20, doc.internal.pageSize.height - 20);

    const element = document.getElementById("prueba");
    const textContent = element?.textContent?.trim() || '';

    doc.text(textContent, 20, 20);

    doc.save('book-list.pdf');
  }
}
