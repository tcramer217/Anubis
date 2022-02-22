import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../service/auth.service";
import {TokenStorageService} from "../service/token-storage.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  submitted: boolean = false;
  isLoggedIn: boolean = false;
  isLoginFailed: boolean = false;

  errorMessage: string = '';
  roles: string[] = [];

  constructor(
    private authService: AuthService,
    private tokenService: TokenStorageService,
    private formBuilder: FormBuilder,
  ) {
    this.loginForm = this.formBuilder.group(
      {
        username: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
        password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
      }
    );
  }

  get f(): { [key: string]: AbstractControl } {
    return this.loginForm.controls;
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenService.getUser().roles;
    }
  }

  onSubmit(): void {
    console.log('this.f', this.f);
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    console.log(JSON.stringify(this.loginForm.value, null, 2));
    const {username, password} = this.loginForm.value;
    this.authService.login(username, password)
      .subscribe(
        data => {
          console.log('Data:', data);
          this.tokenService.saveToken(data.accessToken);
          this.tokenService.saveUser(data);
          this.isLoginFailed = false;
          this.isLoggedIn = true;
          this.roles = this.tokenService.getUser().roles;
          this.reloadPage();
        },
        error => {
          console.log('error:', error);
          this.errorMessage = error.message;
          this.isLoggedIn = false;
          this.submitted = false;
          this.isLoginFailed = true;
        }
      );
  }

  reloadPage(): void {
    window.location.reload();
  }

}
