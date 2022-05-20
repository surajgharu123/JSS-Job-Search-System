import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatingjobsComponent } from './creatingjobs.component';

describe('CreatingjobsComponent', () => {
  let component: CreatingjobsComponent;
  let fixture: ComponentFixture<CreatingjobsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatingjobsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatingjobsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
