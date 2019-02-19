import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewByArtistComponent } from './view-by-artist.component';

describe('ViewByArtistComponent', () => {
  let component: ViewByArtistComponent;
  let fixture: ComponentFixture<ViewByArtistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewByArtistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewByArtistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
