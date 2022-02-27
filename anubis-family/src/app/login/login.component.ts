import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../service/auth.service';
import {TokenStorageService} from '../service/token-storage.service';
import {ProfileService} from '../service/profile.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  submitted = false;
  isLoggedIn = false;
  isLoginFailed = false;

  errorMessage = '';
  roles: string[] = [];

  constructor(
    private authService: AuthService,
    private tokenService: TokenStorageService,
    private formBuilder: FormBuilder,
    private profileService: ProfileService,
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
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    const {username, password} = this.loginForm.value;
    this.authService.login(username, password)
      .subscribe(
        data => {
          this.tokenService.saveToken(data.accessToken);
          this.tokenService.saveUser(data);
          this.isLoginFailed = false;
          this.isLoggedIn = true;
          this.roles = this.tokenService.getUser().roles;
          this.profileService.getProfile(data.id).subscribe(result => {
            this.tokenService.saveProfile(result);
          });
          this.reloadPage();
        },
        error => {
          this.errorMessage = error.message;
          this.isLoggedIn = false;
          this.submitted = false;
          this.isLoginFailed = true;
          throw new Error(error.message);
        }
      );
  }

  reloadPage(): void {
    window.location.reload();
  }

}
