import {Component, OnInit} from '@angular/core';
import {DailyTaskService} from '../daily-task.service';

@Component({
  selector: 'app-anubis-daily-tasks',
  templateUrl: './anubis-daily-tasks.component.html',
  styleUrls: ['./anubis-daily-tasks.component.less']
})
export class AnubisDailyTasksComponent implements OnInit {
  // private tasks: Observable<any>;
  private tasks: any;

  constructor(private taskService: DailyTaskService) {
    this.taskService.getDailyTasks().subscribe((response) => {
      console.log('tasks:', response);
      this.tasks = response;
    }, (error) => {
      console.log('error:', error);
    });
  }

  ngOnInit(): void {
    console.log('fancy things', this.tasks);
  }

}
