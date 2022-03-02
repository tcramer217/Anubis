import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-daily-task-create',
  templateUrl: './daily-task-create.component.html',
  styleUrls: ['./daily-task-create.component.less']
})
export class DailyTaskCreateComponent implements OnInit {

  constructor(
    public dialogReference: MatDialogRef<DailyTaskCreateComponent>,
  ) {
  }

  ngOnInit(): void {
  }

  createTask(): void {
    console.log('create');
    this.dialogReference.close(true);
  }

  onNoClick(): void {
    this.dialogReference.close();
  }

}
