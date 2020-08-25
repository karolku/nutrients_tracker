import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailedFoodInfoComponent } from './detailed-food-info.component';

describe('DetailedFoodInfoComponent', () => {
  let component: DetailedFoodInfoComponent;
  let fixture: ComponentFixture<DetailedFoodInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailedFoodInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailedFoodInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
