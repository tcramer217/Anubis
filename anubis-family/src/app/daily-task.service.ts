import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Task} from './task';

@Injectable({
  providedIn: 'root'
})
export class DailyTaskService {

  private DAILY_TASK_URL = 'http://localhost:8080/api/tasks/daily';
  private tasks: Task[];

  constructor(
    private httpClient: HttpClient
  ) {
    this.tasks = [
      { id: 11, name: 'Dr Nice' },
      { id: 12, name: 'Narco' },
      { id: 13, name: 'Bombasto' },
      { id: 14, name: 'Celeritas' },
      { id: 15, name: 'Magneta' },
      { id: 16, name: 'RubberMan' },
      { id: 17, name: 'Dynama' },
      { id: 18, name: 'Dr IQ' },
      { id: 19, name: 'Magma' },
      { id: 20, name: 'Tornado' }
    ];
  }

  // getDailyTasks(): Observable<any> {
  getDailyTasks(): Task[] {
    // return of(this.tasks);
    return this.tasks;
    // return this.httpClient.get(this.DAILY_TASK_URL);
  }
}
