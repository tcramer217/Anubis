import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AnubisDailyTasksComponent} from './anubis-daily-tasks/anubis-daily-tasks.component';
import {AnubisWeeklyTasksComponent} from './anubis-weekly-tasks/anubis-weekly-tasks.component';

const routes: Routes = [
  { path: 'daily-tasks', component: AnubisDailyTasksComponent },
  { path: 'weekly-tasks', component: AnubisWeeklyTasksComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
