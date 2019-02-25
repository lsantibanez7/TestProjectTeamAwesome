import { TestBed } from '@angular/core/testing';

import { GetFavoritesService } from './get-favorites.service';

describe('GetFavoritesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetFavoritesService = TestBed.get(GetFavoritesService);
    expect(service).toBeTruthy();
  });
});
