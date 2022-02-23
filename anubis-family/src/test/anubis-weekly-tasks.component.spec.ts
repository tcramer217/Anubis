import {ComponentFixture, TestBed} from '@angular/core/testing';

import {WeeklyTasksComponent} from '../app/weekly-tasks/weekly-tasks.component';

describe('AnubisWeeklyTasksComponent', () => {
  let component: WeeklyTasksComponent;
  let fixture: ComponentFixture<WeeklyTasksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WeeklyTasksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WeeklyTasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
