import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../../service/token-storage.service';
import {User} from '../../model/user';
import {ProfileService} from '../../service/profile.service';
import * as _ from 'lodash';
import {Profile} from '../../model/profile';

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
    console.log('this.currentUser', this.currentUser);
    console.log('this.userProfile', this.userProfile);
    console.log('this.originalProfile', this.originalProfile);
  }

  ngOnInit(): void {
  }

  toggleEdit(): void {
    this.isEditMode = !this.isEditMode;
    console.log('isEditMode:', this.isEditMode);
  }

  saveEdit(): void {
    if (_.isEqual(this.originalProfile, this.userProfile)) {
      // noop
      console.log('same!');
    } else {
      this.userProfile.email = this.currentUser.email;
      console.log('different!', this.userProfile);
      this.profileService.saveProfile(this.userProfile).subscribe((response) => {
        this.tokenService.saveProfile(response);
      });
    }
    this.isEditMode = false;
  }

}
