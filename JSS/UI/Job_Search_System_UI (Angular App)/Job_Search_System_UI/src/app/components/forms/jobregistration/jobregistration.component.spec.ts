import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobregistrationComponent } from './jobregistration.component';

describe('JobregistrationComponent', () => {
  let component: JobregistrationComponent;
  let fixture: ComponentFixture<JobregistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JobregistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobregistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
