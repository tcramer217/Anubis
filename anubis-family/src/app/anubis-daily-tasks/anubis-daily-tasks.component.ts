import {Component, OnInit} from '@angular/core';
import {DailyTaskService} from '../daily-task.service';
import {Task} from '../task';

@Component({
  selector: 'app-anubis-daily-tasks',
  templateUrl: './anubis-daily-tasks.component.html',
  styleUrls: ['./anubis-daily-tasks.component.less']
})
export class AnubisDailyTasksComponent implements OnInit {
  // private tasks: Observable<any>;
  private readonly tasks: Task[];

  constructor(private taskService: DailyTaskService) {
    this.tasks = this.taskService.getDailyTasks();
  }

  ngOnInit(): void {
    console.log('fancy things', this.tasks);
  }

}
