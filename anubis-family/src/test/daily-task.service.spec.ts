import { TestBed } from '@angular/core/testing';
import {DailyTaskService} from '../app/daily-task.service';

describe('DailyTaskService', () => {
  let service: DailyTaskService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DailyTaskService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
