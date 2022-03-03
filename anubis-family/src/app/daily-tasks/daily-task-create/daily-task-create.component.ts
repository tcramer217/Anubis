import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DailyTaskService} from '../../service/daily-task.service';

@Component({
  selector: 'app-daily-task-create',
  templateUrl: './daily-task-create.component.html',
  styleUrls: ['./daily-task-create.component.less']
})
export class DailyTaskCreateComponent implements OnInit {
  newDailyTaskForm: FormGroup;
  selectedAssignee: number;

  submitted = false;
  errorMessage = '';

  constructor(
    private formBuilder: FormBuilder,
    private dailyTaskService: DailyTaskService,
    public dialogReference: MatDialogRef<DailyTaskCreateComponent>,
  ) {
    this.newDailyTaskForm = this.formBuilder.group({
      id: [null],
      name: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(50)]],
      assignedTo: [{ id: 8 }],
      createdBy: [{ id : 11 }],
      createdAt: [new Date()],
      complete: [false, []],
      inProgress: [false, []],
      reminders: [[]],
    })
  }

  get f(): { [key: string]: AbstractControl } {
    return this.newDailyTaskForm.controls;
  }

  ngOnInit(): void {
  }

  createTask(): void {
    this.submitted = true;
    if (this.newDailyTaskForm.invalid) {
      return;
    }
    this.dailyTaskService.createNewTask(this.newDailyTaskForm.value).subscribe((result) => {
      this.dialogReference.close(true);
    })
  }

  onNoClick(): void {
    this.dialogReference.close();
  }

}
