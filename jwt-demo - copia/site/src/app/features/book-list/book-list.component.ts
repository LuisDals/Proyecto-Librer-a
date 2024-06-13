/* import { Component } from '@angular/core';
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

    // Definir un área imprimible en el PDF
    doc.setLineWidth(0.5);
    doc.rect(10, 10, doc.internal.pageSize.width - 20, doc.internal.pageSize.height - 20);

    // Obtener el texto del elemento con ID 'prueba'
    const element = document.getElementById("prueba");
    const textContent = element ? element.textContent.trim() : '';

    // Agregar el texto al PDF
    doc.text(textContent, 20, 20);

    // Guardar el PDF con el nombre 'book-list.pdf'
    doc.save('book-list.pdf');
  }
}
 */
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

    // Definir un área imprimible en el PDF
    doc.setLineWidth(0.5);
    doc.rect(10, 10, doc.internal.pageSize.width - 20, doc.internal.pageSize.height - 20);

    // Obtener el texto del elemento con ID 'prueba' de manera segura
    const element = document.getElementById("prueba");
    const textContent = element?.textContent?.trim() || '';

    // Agregar el texto al PDF
    doc.text(textContent, 20, 20);

    // Guardar el PDF con el nombre 'book-list.pdf'
    doc.save('book-list.pdf');
  }
}
