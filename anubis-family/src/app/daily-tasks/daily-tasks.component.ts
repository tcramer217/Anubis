import {Component, OnInit} from '@angular/core';
import {DailyTaskService} from '../service/daily-task.service';
import {Task} from '../model/task';
import {SelectionModel} from '@angular/cdk/collections';
import {DailyTaskCreateComponent} from "./daily-task-create/daily-task-create.component";
import {MatDialog} from "@angular/material/dialog";
import {Router} from "@angular/router";

@Component({
  selector: 'app-anubis-daily-tasks',
  templateUrl: './daily-tasks.component.html',
  styleUrls: ['./daily-tasks.component.less']
})
export class DailyTasksComponent implements OnInit {
  public tasks: Task[] = [];
  public columns: string[] = [];
  public selection = new SelectionModel<Task>(true, []);

  constructor(
    private dialog: MatDialog,
    private taskService: DailyTaskService,
    private router: Router
  ) {
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

  taskCompleted(task: Task): void {
    console.log('clicked', task);
    this.taskService.markCompleted(task.id, !task.complete).subscribe((response) => {
      console.log('response', response);
    });
  }

  addTask(): void {
    // launch add task modal
    const dialogRef = this.dialog.open(DailyTaskCreateComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed:', result);
      window.location.reload();
    });
  }

}
