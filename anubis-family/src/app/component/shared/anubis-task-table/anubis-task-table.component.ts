import {Component, Input, OnInit} from '@angular/core';
import { Task } from 'src/app/model/task';
import {DailyTaskService} from '../../../service/daily-task.service';

@Component({
  selector: 'app-anubis-task-table',
  templateUrl: './anubis-task-table.component.html',
  styleUrls: ['./anubis-task-table.component.less']
})
export class AnubisTaskTableComponent implements OnInit {

  public myTasks: Task[] = [];

  @Input('tasks')
  public allMyTasks: Task[] = [];

  @Input()
  columns: string[] = [];

  @Input()
  tableTitle: string = "Tasks";

  filterCompleted = false;

  constructor(
    private taskService: DailyTaskService
  ) {
  }

  ngOnInit(): void {
    this.myTasks = this.allMyTasks;
  }

  toggleFilterCompleted(): void {
    this.filterCompleted = !this.filterCompleted;
    this.myTasks = this.filterTasks(this.filterCompleted, this.myTasks, this.allMyTasks);
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
    const taskToComplete = this.allMyTasks.find((value => value.id === task.id));
    if (typeof taskToComplete !== 'undefined') {
      taskToComplete.complete = isComplete;
    }
    this.taskService.markCompleted(task.id, isComplete).subscribe((response) => {
      this.refreshMyTasks();
    });
  }

  refreshMyTasks(): void {
    this.taskService.getMyDailyTasks().subscribe((response) => {
      debugger;
      this.myTasks = response;
      this.allMyTasks = response;
    }, (error) => {
      throw new Error(error);
    });
  }

}
