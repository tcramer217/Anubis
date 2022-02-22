import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AnubisDailyTasksComponent} from './anubis-daily-tasks/anubis-daily-tasks.component';
import {AnubisWeeklyTasksComponent} from './anubis-weekly-tasks/anubis-weekly-tasks.component';
import {DailyTaskComponent} from './anubis-daily-tasks/daily-task/daily-task.component';
import {RegisterComponent} from './register/register.component';

const routes: Routes = [
  {path: 'register', component: RegisterComponent},
  {path: 'daily-tasks', component: AnubisDailyTasksComponent},
  {path: 'daily-tasks/:id', component: DailyTaskComponent},
  {path: 'weekly-tasks', component: AnubisWeeklyTasksComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
