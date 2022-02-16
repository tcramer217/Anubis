import {AbstractControl, ValidatorFn} from '@angular/forms';

export default class Validation {
  static match(controlName: string, checkControlName: string): ValidatorFn {
    return (controls: AbstractControl) => {
      const control = controls.get(controlName);
      const checkControl = controls.get(checkControlName);
      if (checkControl !== null && checkControl.errors && !checkControl.errors.matching) {
        return null;
      }
      if (control !== null && checkControl !== null && control.value !== checkControl.value) {
        checkControl.setErrors({matching: true});
        return {matching: true};
      } else {
        return null;
      }
    };
  }
}
