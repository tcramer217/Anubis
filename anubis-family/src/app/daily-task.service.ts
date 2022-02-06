import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DailyTaskService {

  private DAILY_TASK_URL = 'http://localhost:8080/api/task/daily';
  // private tasks: Task[];

  constructor(
    private httpClient: HttpClient
  ) {

  }

  getDailyTasks(): Observable<any> {
    return this.httpClient.get(this.DAILY_TASK_URL);
  }
}
