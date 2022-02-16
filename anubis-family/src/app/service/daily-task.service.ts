import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Task} from "../model/task";

@Injectable({
  providedIn: 'root'
})
export class DailyTaskService {

  private DAILY_TASK_URL = 'http://localhost:8080/api/task/daily';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getDailyTasks(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(this.DAILY_TASK_URL);
  }
}
