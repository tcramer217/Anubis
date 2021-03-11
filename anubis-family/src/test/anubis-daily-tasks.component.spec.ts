import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AnubisDailyTasksComponent } from '../app/anubis-daily-tasks/anubis-daily-tasks.component';

describe('AnubisDailyTasksComponent', () => {
  let component: AnubisDailyTasksComponent;
  let fixture: ComponentFixture<AnubisDailyTasksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnubisDailyTasksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnubisDailyTasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
