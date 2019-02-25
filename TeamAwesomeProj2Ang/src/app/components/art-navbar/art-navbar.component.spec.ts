import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtNavbarComponent } from './art-navbar.component';

describe('ArtNavbarComponent', () => {
  let component: ArtNavbarComponent;
  let fixture: ComponentFixture<ArtNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArtNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
