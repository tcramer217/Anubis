import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {LoginComponent} from '../../login/login.component';

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.less']
})
export class LoginDialogComponent {

  @ViewChild(LoginComponent)
  loginComponent!: LoginComponent;

  constructor(
    public dialogReference: MatDialogRef<LoginDialogComponent>,
  ) {
  }

  onNoClick(): void {
    this.dialogReference.close();
  }

  logInUser(): void {
    this.loginComponent.onSubmit();
    this.dialogReference.close('Logged In.');
  }

}
