import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MiniMentalComponent } from './mini-mental.component';

describe('MiniMentalComponent', () => {
  let component: MiniMentalComponent;
  let fixture: ComponentFixture<MiniMentalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MiniMentalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MiniMentalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
