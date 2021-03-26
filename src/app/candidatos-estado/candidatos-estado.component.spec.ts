import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatosEstadoComponent } from './candidatos-estado.component';

describe('CandidatosEstadoComponent', () => {
  let component: CandidatosEstadoComponent;
  let fixture: ComponentFixture<CandidatosEstadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CandidatosEstadoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CandidatosEstadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
