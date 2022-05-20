import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatedJobByEmployeeComponent } from './created-job-by-employee.component';

describe('CreatedJobByEmployeeComponent', () => {
  let component: CreatedJobByEmployeeComponent;
  let fixture: ComponentFixture<CreatedJobByEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatedJobByEmployeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatedJobByEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
