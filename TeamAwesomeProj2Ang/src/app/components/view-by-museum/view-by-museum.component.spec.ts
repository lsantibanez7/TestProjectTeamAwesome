import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewByMuseumComponent } from './view-by-museum.component';

describe('ViewByMuseumComponent', () => {
  let component: ViewByMuseumComponent;
  let fixture: ComponentFixture<ViewByMuseumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewByMuseumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewByMuseumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
