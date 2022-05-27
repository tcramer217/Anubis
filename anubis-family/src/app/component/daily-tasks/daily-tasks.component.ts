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
  public myDailyTasks: Task[] = [];
  public familyDailyTasks: Task[] = [];

  public allMyDailyTasks: Task[] = [];
  public allFamilyDailyTasks: Task[] = [];

  public columns: string[] = [];

  myTasksFilterCompleted = false;
  familyTasksFilterCompleted = false;

  constructor(
    private dialog: MatDialog,
    private taskService: DailyTaskService,
  ) {
  }

  ngOnInit(): void {
    this.refreshMyDailyTasks();
    this.refreshFamilyDailyTasks();
  }

  getTasks(): Task[] {
    return this.myDailyTasks;
  }

  toggleFilterMyDailyCompletedTasks(): void {
    this.myTasksFilterCompleted = !this.myTasksFilterCompleted;
    this.myDailyTasks = this.filterTasks(this.myTasksFilterCompleted, this.myDailyTasks, this.allMyDailyTasks);
  }

  toggleFilterFamilyDailyCompletedTasks(): void {
    this.familyTasksFilterCompleted = !this.familyTasksFilterCompleted;
    this.familyDailyTasks = this.filterTasks(this.familyTasksFilterCompleted, this.familyDailyTasks, this.allFamilyDailyTasks);
  }

  private filterTasks = function (filterCompleted: boolean, arrayToFilter: Task[], allTasks: Task[]) {
    if (filterCompleted) {
      arrayToFilter = arrayToFilter.filter((task) => {
        return !task.complete;
      });
    } else {
      arrayToFilter = allTasks;
    }
    return arrayToFilter;
  }

  taskCompleted(task: Task): void {
    const isComplete = !task.complete;
    const taskToComplete = this.allMyDailyTasks.find((value => value.id === task.id));
    if (typeof taskToComplete !== 'undefined') {
      taskToComplete.complete = isComplete;
    }
    this.taskService.markCompleted(task.id, isComplete).subscribe((response) => {
      this.refreshMyDailyTasks();
    });
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
      this.columns = ['select', 'name', 'assignedTo'];
      this.myDailyTasks = response;
      this.allMyDailyTasks = response;
    }, (error) => {
      throw new Error(error);
    });
  }

  refreshFamilyDailyTasks(): void {
    this.taskService.getFamilyDailyTasks().subscribe((response) => {
      console.log('response', response);
      this.columns = ['select', 'name', 'assignedTo'];
      this.familyDailyTasks = response;
      this.allFamilyDailyTasks = response;
    }, (error) => {
      throw new Error(error);
    });
  }

}
