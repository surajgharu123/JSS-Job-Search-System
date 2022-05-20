import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobseekerListComponent } from './jobseeker-list.component';

describe('JobseekerListComponent', () => {
  let component: JobseekerListComponent;
  let fixture: ComponentFixture<JobseekerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JobseekerListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobseekerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
