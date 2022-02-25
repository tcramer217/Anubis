import {Component, OnInit} from '@angular/core';
import {DailyTaskService} from '../service/daily-task.service';
import {Task} from '../model/task';

@Component({
  selector: 'app-anubis-daily-tasks',
  templateUrl: './daily-tasks.component.html',
  styleUrls: ['./daily-tasks.component.less']
})
export class DailyTasksComponent implements OnInit {
  public tasks: Task[] = [];
  public columns: string[] = [];

  constructor(private taskService: DailyTaskService) {
  }

  ngOnInit(): void {
    this.taskService.getDailyTasks().subscribe((response) => {
      this.columns = ['name'];
      this.tasks = response;
    }, (error) => {
      throw new Error(error);
    });
  }

  getTasks(): Task[] {
    return this.tasks;
  }
}
