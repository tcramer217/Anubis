import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {RegisterComponent} from '../../register/register.component';

@Component({
  selector: 'app-register-dialog',
  templateUrl: './register-dialog.component.html',
  styleUrls: ['./register-dialog.component.less']
})
export class RegisterDialogComponent implements OnInit {

  @ViewChild(RegisterComponent)
  registerComponent!: RegisterComponent;

  constructor(
    public dialogReference: MatDialogRef<RegisterDialogComponent>,
  ) {
  }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogReference.close();
  }

  registerUser(): void {
    this.registerComponent.onSubmit();
    this.dialogReference.close('Form Submitted.');
  }

}
