import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnubisWeeklyTasksComponent } from './anubis-weekly-tasks.component';

describe('AnubisWeeklyTasksComponent', () => {
  let component: AnubisWeeklyTasksComponent;
  let fixture: ComponentFixture<AnubisWeeklyTasksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnubisWeeklyTasksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnubisWeeklyTasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
