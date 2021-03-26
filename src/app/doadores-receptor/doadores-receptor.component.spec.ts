import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoadoresReceptorComponent } from './doadores-receptor.component';

describe('DoadoresReceptorComponent', () => {
  let component: DoadoresReceptorComponent;
  let fixture: ComponentFixture<DoadoresReceptorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoadoresReceptorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoadoresReceptorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
