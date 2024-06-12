import { TestBed } from '@angular/core/testing';

import { RentBookService } from './rent-book.service';

describe('RentBookService', () => {
  let service: RentBookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RentBookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
