import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DailyTaskService} from '../../service/daily-task.service';
import {Profile} from '../../model/profile';
import {FamilyService} from '../../service/family.service';
import {TokenStorageService} from '../../service/token-storage.service';

@Component({
  selector: 'app-daily-task-create',
  templateUrl: './daily-task-create.component.html',
  styleUrls: ['./daily-task-create.component.less']
})
export class DailyTaskCreateComponent implements OnInit {
  newDailyTaskForm: FormGroup;
  familyMembers: Profile[] = [];

  selectedAssignee = 0;
  submitted = false;
  errorMessage = '';

  constructor(
    private dailyTaskService: DailyTaskService,
    private familyService: FamilyService,
    private tokenService: TokenStorageService,
    private formBuilder: FormBuilder,
    public dialogReference: MatDialogRef<DailyTaskCreateComponent>,
  ) {
    this.newDailyTaskForm = this.formBuilder.group({
      id: [null],
      name: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(50)]],
      assignedTo: [{id: 0}, [Validators.required]],
      createdBy: [{id: this.tokenService.getProfile().id}, [Validators.required]],
      createdAt: [new Date()],
      complete: [false],
      inProgress: [false],
      reminders: [[]],
    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.newDailyTaskForm.controls;
  }

  ngOnInit(): void {
    this.familyService.getFamilyMembers(this.tokenService.getProfile().familyId).subscribe((result) => {
      console.log('familyMembers:', result);
      this.familyMembers = result;
    });
  }

  createTask(): void {
    this.submitted = true;
    if (this.newDailyTaskForm.invalid) {
      return;
    }
    console.log('this.newDailyTaskForm', this.newDailyTaskForm);
    this.dailyTaskService.createNewTask(this.newDailyTaskForm.value).subscribe((result) => {
      this.dialogReference.close(true);
    });
  }

  onNoClick(): void {
    this.dialogReference.close();
  }

}
