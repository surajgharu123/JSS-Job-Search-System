import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobseekerregistrationComponent } from './jobseekerregistration.component';

describe('JobseekerregistrationComponent', () => {
  let component: JobseekerregistrationComponent;
  let fixture: ComponentFixture<JobseekerregistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JobseekerregistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobseekerregistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
