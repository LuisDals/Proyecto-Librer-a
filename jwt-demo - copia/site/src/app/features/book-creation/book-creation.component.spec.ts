import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookCreationComponent } from './book-creation.component';

describe('BookCreationComponent', () => {
  let component: BookCreationComponent;
  let fixture: ComponentFixture<BookCreationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BookCreationComponent]
    });
    fixture = TestBed.createComponent(BookCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
