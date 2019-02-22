import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoggedNavbarComponent } from './logged-navbar.component';

describe('LoggedNavbarComponent', () => {
  let component: LoggedNavbarComponent;
  let fixture: ComponentFixture<LoggedNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoggedNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoggedNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
