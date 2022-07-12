import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Task} from '../model/task';
import {TokenStorageService} from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class DailyTaskService {

  private TASK_URL = 'http://localhost:8080/api/task';
  private DAILY_TASK_URL = this.TASK_URL + '/weekly';
  private WEEKLY_TASK_URL = this.TASK_URL + '/daily';
  constructor(
    private httpClient: HttpClient,
    private tokenService: TokenStorageService
  ) {
  }

  getMyDailyTasks(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(this.DAILY_TASK_URL + '/user/' + this.tokenService.getUser().id);
  }

  getFamilyDailyTasks(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(this.DAILY_TASK_URL + '/family/' + this.tokenService.getProfile().familyId);
  }

  getMyWeeklyTasks(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(this.WEEKLY_TASK_URL + '/user/' + this.tokenService.getUser().id);
  }

  getFamilyWeeklyTasks(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(this.WEEKLY_TASK_URL + '/family/' + this.tokenService.getProfile().familyId);
  }

  createNewTask(newTask: Task): Observable<Task> {
    return this.httpClient.post<Task>(this.DAILY_TASK_URL, newTask);
  }

  markCompleted(taskId: number, isComplete: boolean): Observable<any> {
    const updateIsComplete = { taskId, isComplete };
    return this.httpClient.post(this.TASK_URL + '/complete', updateIsComplete);
  }
}
