import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImcFaixaEtariaComponent } from './imc-faixa-etaria.component';

describe('ImcFaixaEtariaComponent', () => {
  let component: ImcFaixaEtariaComponent;
  let fixture: ComponentFixture<ImcFaixaEtariaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImcFaixaEtariaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImcFaixaEtariaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
