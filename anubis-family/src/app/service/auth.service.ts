import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private AUTH_ENDPOINT = 'http://localhost:8080/api/auth/';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  signup(username: string, email: string, password: string, confirmPassword: string) {
    return this.httpClient.post<any>(this.AUTH_ENDPOINT + 'signup',
      {username, email, password, confirmPassword},
      httpOptions);
  }

  login(username: string, password: string): Observable<any> {
    return this.httpClient.post(this.AUTH_ENDPOINT + 'signin',
      {username, password},
      httpOptions);
  }

  logout(): void {
  }
}
