import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IdadeTipoSanguineoComponent } from './idade-tipo-sanguineo.component';

describe('IdadeTipoSanguineoComponent', () => {
  let component: IdadeTipoSanguineoComponent;
  let fixture: ComponentFixture<IdadeTipoSanguineoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IdadeTipoSanguineoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IdadeTipoSanguineoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
