import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../service/token-storage.service";
import {User} from "../model/user";
import {ProfileService} from "../service/profile.service";
import {Observable} from "rxjs";
import {Profile} from "../model/profile";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.less']
})
export class ProfileComponent implements OnInit {

  currentUser: User;
  userProfile: Profile | undefined;

  constructor(
    private profileService: ProfileService,
    private tokenService: TokenStorageService,
  ) {
    this.currentUser = this.tokenService.getUser();
    console.log('currentUser:', this.currentUser);

  }

  ngOnInit(): void {
    this.getProfile(this.currentUser.id).subscribe(result => {
      console.log('result for getProfile:', result);
      this.userProfile = result;
    })
  }

  getProfile(userId: number): Observable<any> {
    return this.profileService.getProfile(userId);
  }

}
