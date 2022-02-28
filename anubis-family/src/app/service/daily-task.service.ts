import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Task} from '../model/task';
import {TokenStorageService} from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class DailyTaskService {

  private DAILY_TASK_URL = 'http://localhost:8080/api/task/daily';
  private TASK_URL = 'http://localhost:8080/api/task';
  constructor(
    private httpClient: HttpClient,
    private tokenService: TokenStorageService
  ) {
  }

  getDailyTasks(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(this.DAILY_TASK_URL + '/user/' + this.tokenService.getUser().id);
  }

  markCompleted(taskId: number, isComplete: boolean): Observable<any> {
    console.log('patching...')
    const updateIsComplete = { taskId, isComplete };
    return this.httpClient.post(this.TASK_URL + '/complete', updateIsComplete);
  }
}
