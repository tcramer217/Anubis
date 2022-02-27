import { Component, OnInit } from '@angular/core';
import {Profile} from '../../model/profile';
import {TokenStorageService} from '../../service/token-storage.service';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.less']
})
export class ProfileEditComponent implements OnInit {

  profile: Profile | {};

  constructor(
    private tokenService: TokenStorageService,
  ) {
    this.profile = this.tokenService.getProfile();
  }

  ngOnInit(): void {
  }

}
