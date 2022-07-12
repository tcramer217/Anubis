import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Profile} from '../model/profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private AUTH_ENDPOINT = 'http://localhost:8080/api/profile';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getProfile(userId: number): Observable<any> {
    return this.httpClient.get(this.AUTH_ENDPOINT + '/' + userId);
  }

  saveProfile(profile: Profile): Observable<any> {
    return this.httpClient.post(this.AUTH_ENDPOINT + '/save', profile);
  }
}
