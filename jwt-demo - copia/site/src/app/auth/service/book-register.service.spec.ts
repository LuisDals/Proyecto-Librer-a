import { TestBed } from '@angular/core/testing';

import { BookRegisterService } from './book-register.service';

describe('BookRegisterService', () => {
  let service: BookRegisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookRegisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
