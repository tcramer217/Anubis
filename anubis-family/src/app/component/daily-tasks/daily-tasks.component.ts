import {Component, OnInit} from '@angular/core';
import {DailyTaskService} from '../../service/daily-task.service';
import {Task} from '../../model/task';
import {DailyTaskCreateComponent} from './daily-task-create/daily-task-create.component';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-anubis-daily-tasks',
  templateUrl: './daily-tasks.component.html',
  styleUrls: ['./daily-tasks.component.less']
})
export class DailyTasksComponent implements OnInit {

  public allMyDailyTasks: Task[] = [];
  public allFamilyDailyTasks: Task[] = [];

  public columns: string[] = ['select', 'name', 'assignedTo'];

  constructor(
    private dialog: MatDialog,
    private taskService: DailyTaskService,
  ) {
  }

  ngOnInit(): void {
    this.refreshMyDailyTasks();
    this.refreshFamilyDailyTasks();
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

  refreshFamilyDailyTasks(): void {
    this.taskService.getFamilyDailyTasks().subscribe((response) => {
      this.allFamilyDailyTasks = response;
    }, (error) => {
      throw new Error(error);
    });
  }

}
