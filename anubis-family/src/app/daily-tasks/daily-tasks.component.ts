import {Component, OnInit} from '@angular/core';
import {DailyTaskService} from '../service/daily-task.service';
import {Task} from '../model/task';
import {SelectionModel} from '@angular/cdk/collections';

@Component({
  selector: 'app-anubis-daily-tasks',
  templateUrl: './daily-tasks.component.html',
  styleUrls: ['./daily-tasks.component.less']
})
export class DailyTasksComponent implements OnInit {
  public tasks: Task[] = [];
  public columns: string[] = [];
  public selection = new SelectionModel<Task>(true,  []);

  constructor(private taskService: DailyTaskService) {
  }

  ngOnInit(): void {
    this.taskService.getDailyTasks().subscribe((response) => {
      console.log('tasksService.getDailyTasks:', response);
      this.columns = ['select', 'name', 'assignedTo'];
      this.tasks = response;
    }, (error) => {
      throw new Error(error);
    });
  }

  getTasks(): Task[] {
    return this.tasks;
  }

  taskCompleted(task: Task) : void {
    console.log('clicked');
  }

}
