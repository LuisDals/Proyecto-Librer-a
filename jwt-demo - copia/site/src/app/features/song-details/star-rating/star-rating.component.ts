import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.scss']
})
export class StarRatingComponent {
  @Input() stars: number = 0; 
  @Input() maxRating: number = 5;
  @Output() ratingSelected = new EventEmitter<number>();

  // Método para seleccionar la calificación y emitir el evento con el número de estrellas seleccionadas
  selectRating(rating: number): void {
    this.ratingSelected.emit(rating);
  }

  // Método para manejar la selección de estrellas
  rate(starsSelected: number): void {
    this.stars = starsSelected;
    this.ratingSelected.emit(this.stars);
  }

  // Método para comprobar si una estrella está llena o vacía
  isStarFull(index: number): boolean {
    return index < this.stars;
  }

  // Método para generar un rango de números del 1 al máximo de calificación
  generateRange(): number[] {
    return Array(this.maxRating).fill(0).map((x, i) => i + 1);
  }
}
