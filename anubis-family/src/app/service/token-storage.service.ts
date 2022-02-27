import {Injectable} from '@angular/core';
import {Profile} from '../model/profile';
import {User} from '../model/user';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';
const PROFILE_KEY = 'user-profile';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() {
  }

  signOut(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user: User): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return {};
  }

  public saveProfile(profile: Profile): void {
    window.sessionStorage.removeItem(PROFILE_KEY);
    window.sessionStorage.setItem(PROFILE_KEY, JSON.stringify(profile));
  }

  public getProfile(): any {
    const profile = window.sessionStorage.getItem(PROFILE_KEY);
    if (profile) {
      return JSON.parse(profile);
    }
    return {};
  }
}
