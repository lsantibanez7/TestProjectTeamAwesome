import { TestBed } from '@angular/core/testing';

import { LogoutServiceService } from './logout-service.service';

describe('LogoutServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LogoutServiceService = TestBed.get(LogoutServiceService);
    expect(service).toBeTruthy();
  });
});
