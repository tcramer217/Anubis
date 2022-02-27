import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../service/token-storage.service';
import {User} from '../model/user';
import {ProfileService} from '../service/profile.service';
import * as _ from 'lodash';
import {Profile} from '../model/profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.less']
})
export class ProfileComponent implements OnInit {

  isEditMode = false;
  currentUser: User;
  userProfile: Profile;
  originalProfile: Profile;

  constructor(
    private profileService: ProfileService,
    private tokenService: TokenStorageService,
  ) {
    this.currentUser = this.tokenService.getUser();
    this.userProfile = this.tokenService.getProfile();
    this.originalProfile = this.tokenService.getProfile();
  }

  ngOnInit(): void {
  }

  toggleEdit(): void {
    this.isEditMode = !this.isEditMode;
    console.log('isEditMode:', this.isEditMode);
  }

  saveEdit(): void {
    if (_.isEqual(this.originalProfile, this.userProfile)) {
      console.log('same!');
    } else {
      console.log('different!');
      this.profileService.saveProfile(this.userProfile);
    }
    this.isEditMode = false;
  }

}
