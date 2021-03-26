import { TestBed } from '@angular/core/testing';

import { BuscasService } from './buscas.service';

describe('BuscasService', () => {
  let service: BuscasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BuscasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
