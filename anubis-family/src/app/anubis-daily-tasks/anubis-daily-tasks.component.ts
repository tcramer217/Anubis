import {Component, OnInit} from '@angular/core';
import {DailyTaskService} from '../daily-task.service';
import {Task} from "../task";

@Component({
  selector: 'app-anubis-daily-tasks',
  templateUrl: './anubis-daily-tasks.component.html',
  styleUrls: ['./anubis-daily-tasks.component.less']
})
export class AnubisDailyTasksComponent implements OnInit {
  private tasks: Task[] = [];

  constructor(private taskService: DailyTaskService) {}

  ngOnInit(): void {
    this.taskService.getDailyTasks().subscribe((response) => {
      console.log('tasks:', response);
      this.tasks = response;
    }, (error) => {
      console.log('error:', error);
    });
  }

  getTasks(): Task[] {
    return this.tasks;
  }
}
