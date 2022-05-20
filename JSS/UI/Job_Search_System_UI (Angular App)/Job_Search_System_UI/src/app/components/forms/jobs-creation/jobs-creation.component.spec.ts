import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobsCreationComponent } from './jobs-creation.component';

describe('JobsCreationComponent', () => {
  let component: JobsCreationComponent;
  let fixture: ComponentFixture<JobsCreationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JobsCreationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobsCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
