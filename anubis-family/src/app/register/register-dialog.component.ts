import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-register-dialog',
  templateUrl: './register-dialog.component.html',
  styleUrls: ['./register-dialog.component.less']
})
export class RegisterDialogComponent implements OnInit {

  constructor(
    public dialogReference: MatDialogRef<RegisterDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: FormGroup
  ) {
  }

  ngOnInit(): void {
  }

  onNoClick() {
    this.dialogReference.close();
  }

  registerUser(): void {

  }

}
