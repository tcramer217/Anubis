import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {LoginComponent} from "../login.component";

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.less']
})
export class LoginDialogComponent implements OnInit {

  @ViewChild(LoginComponent)
  loginComponent!: LoginComponent;

  constructor(
    public dialogReference: MatDialogRef<LoginDialogComponent>,
  ) {
  }

  ngOnInit(): void {
  }

  onNoClick() {
    this.dialogReference.close();
  }

  logInUser(): void {
    this.loginComponent.onSubmit();
    this.dialogReference.close('Logged In.');
  }

}
