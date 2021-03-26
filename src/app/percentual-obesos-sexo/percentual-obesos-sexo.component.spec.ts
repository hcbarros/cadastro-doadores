import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PercentualObesosSexoComponent } from './percentual-obesos-sexo.component';

describe('PercentualObesosSexoComponent', () => {
  let component: PercentualObesosSexoComponent;
  let fixture: ComponentFixture<PercentualObesosSexoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PercentualObesosSexoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PercentualObesosSexoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
