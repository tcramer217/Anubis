import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../service/auth.service';
import {AbstractControl, UntypedFormBuilder, UntypedFormGroup, Validators} from '@angular/forms';
import Validation from '../../util/Validation';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.less']
})
export class RegisterComponent implements OnInit {

  registerForm: UntypedFormGroup;

  submitted = false;
  isSuccessful = false;
  isSignUpFailed = false;

  errorMessage = '';

  constructor(
    private authService: AuthService,
    private formBuilder: UntypedFormBuilder,
  ) {
    this.registerForm = this.formBuilder.group(
      {
        // fullName: ['', Validators.required],
        username: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
        confirmPassword: ['', Validators.required],
        // acceptTerms: [false, Validators.requiredTrue],
      },
      {
        validators: [Validation.match('password', 'confirmPassword')]
      }
    );
  }

  get f(): { [key: string]: AbstractControl } {
    return this.registerForm.controls;
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    console.log(JSON.stringify(this.registerForm.value, null, 2));
    const {username, email, password, confirmPassword} = this.registerForm.value;
    this.authService.signup(username, email, password, confirmPassword)
      .subscribe(
        data => {
          this.submitted = true;
          this.isSuccessful = true;
          this.isSignUpFailed = false;
        },
        error => {
          this.errorMessage = error.error.getMessage();
          this.isSuccessful = false;
          this.submitted = false;
          this.isSignUpFailed = true;
        }
      );
  }

  onReset(): void {
    this.submitted = false;
    this.registerForm.reset();
  }

}
