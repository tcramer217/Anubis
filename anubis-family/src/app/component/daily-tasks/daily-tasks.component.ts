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
  public displayTasks: Task[] = [];
  public allTasks: Task[] = [];
  public columns: string[] = [];

  filterCompleted = false;

  constructor(
    private dialog: MatDialog,
    private taskService: DailyTaskService,
  ) {
  }

  ngOnInit(): void {
    this.refreshTasks();
  }

  getTasks(): Task[] {
    return this.displayTasks;
  }

  toggleFilterOutCompletedTasks(): void {
    this.filterCompleted = !this.filterCompleted;
    console.log('filter tasks');
    if (this.filterCompleted) {
      this.displayTasks = this.displayTasks.filter((task) => {
        return !task.complete;
      });
    } else {
      this.displayTasks = this.allTasks;
    }
  }

  taskCompleted(task: Task): void {
    console.log('clicked', task);
    const isComplete = !task.complete;
    console.log('isComplete', isComplete);
    const mine = this.allTasks.find((value => value.id === task.id));
    console.log('mine', mine);
    if (typeof mine !== 'undefined') {
      mine.complete = isComplete;
    }
    console.log('mine after', mine);
    this.taskService.markCompleted(task.id, isComplete).subscribe((response) => {
      console.log('response', response);
      this.refreshTasks();
    });
  }

  addTask(): void {
    // launch add task modal
    const dialogRef = this.dialog.open(DailyTaskCreateComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed:', result);
      if (typeof result !== 'undefined') {
        window.location.reload();
      }
    });
  }

  refreshTasks(): void {
    this.taskService.getDailyTasks().subscribe((response) => {
      console.log('tasksService.getDailyTasks:', response);
      this.columns = ['select', 'name', 'assignedTo'];
      this.displayTasks = response;
      this.allTasks = response;
    }, (error) => {
      throw new Error(error);
    });
  }

}
