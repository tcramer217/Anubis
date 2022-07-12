import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Profile} from '../model/profile';

@Injectable({
  providedIn: 'root'
})
export class FamilyService {

  private FAMILY_URL = 'http://localhost:8080/api/family';

  constructor(
    private httpClient: HttpClient,
  ) {
  }

  getFamilyMembers(familyId: number): Observable<Profile[]> {
    return this.httpClient.get<Profile[]>(this.FAMILY_URL + '/' + familyId + '/members');
  }
}
