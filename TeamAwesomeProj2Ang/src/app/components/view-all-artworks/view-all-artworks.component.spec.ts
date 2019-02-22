import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllArtworksComponent } from './view-all-artworks.component';

describe('ViewAllArtworksComponent', () => {
  let component: ViewAllArtworksComponent;
  let fixture: ComponentFixture<ViewAllArtworksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllArtworksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllArtworksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
