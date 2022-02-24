import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DailyTasksComponent} from './daily-tasks/daily-tasks.component';
import {WeeklyTasksComponent} from './weekly-tasks/weekly-tasks.component';
import {DailyTaskComponent} from './daily-tasks/daily-task/daily-task.component';
import {RegisterComponent} from './register/register.component';
import {CalendarComponent} from './calendar/calendar.component';
import {ProfileComponent} from './profile/profile.component';

const routes: Routes = [
  {path: 'register', component: RegisterComponent},
  {path: 'daily-tasks', component: DailyTasksComponent},
  {path: 'daily-tasks/:id', component: DailyTaskComponent},
  {path: 'weekly-tasks', component: WeeklyTasksComponent},
  {path: 'calendar', component: CalendarComponent},
  {path: 'profile', component: ProfileComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
