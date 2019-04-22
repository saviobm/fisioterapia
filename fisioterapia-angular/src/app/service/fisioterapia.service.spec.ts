import { TestBed } from '@angular/core/testing';

import { FisioterapiaService } from './fisioterapia.service';

describe('FisioterapiaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FisioterapiaService = TestBed.get(FisioterapiaService);
    expect(service).toBeTruthy();
  });
});
