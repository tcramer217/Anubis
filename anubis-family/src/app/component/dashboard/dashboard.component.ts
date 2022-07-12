import { Component, OnInit } from '@angular/core';
import {Task} from '../../model/task';
import {MatDialog} from '@angular/material/dialog';
import {DailyTaskService} from '../../service/daily-task.service';
import {DailyTaskCreateComponent} from '../daily-tasks/daily-task-create/daily-task-create.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.less']
})
export class DashboardComponent implements OnInit {

  public allMyDailyTasks: Task[] = [];
  public allMyWeeklyTasks: Task[] = [];

  public columns: string[] = ['select', 'name', 'assignedTo'];

  constructor(
    private dialog: MatDialog,
    private taskService: DailyTaskService,
  ) {
  }

  ngOnInit(): void {
    this.refreshMyDailyTasks();
    this.refreshMyWeeklyTasks();
  }

  addTask(): void {
    // launch add task modal
    const dialogRef = this.dialog.open(DailyTaskCreateComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      if (typeof result !== 'undefined') {
        window.location.reload();
      }
    });
  }

  refreshMyDailyTasks(): void {
    this.taskService.getMyDailyTasks().subscribe((response) => {
      this.allMyDailyTasks = response;
    }, (error) => {
      throw new Error(error);
    });
  }

  refreshMyWeeklyTasks(): void {
    this.taskService.getMyWeeklyTasks().subscribe((response) => {
      this.allMyWeeklyTasks = response;
    }, (error) => {
      throw new Error(error);
    });
  }

}
