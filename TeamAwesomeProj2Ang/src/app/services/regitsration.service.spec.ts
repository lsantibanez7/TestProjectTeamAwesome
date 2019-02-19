import { TestBed } from '@angular/core/testing';

import { RegitsrationService } from './regitsration.service';

describe('RegitsrationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegitsrationService = TestBed.get(RegitsrationService);
    expect(service).toBeTruthy();
  });
});
