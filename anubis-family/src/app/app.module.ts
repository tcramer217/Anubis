import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppMaterialModule} from './app-material.module';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './component/app.component';

import {LayoutModule} from '@angular/cdk/layout';

import {NavigationComponent} from './component/navigation/navigation.component';
import {DailyTasksComponent} from './component/daily-tasks/daily-tasks.component';
import {WeeklyTasksComponent} from './component/weekly-tasks/weekly-tasks.component';
import {HttpClientModule} from '@angular/common/http';
import {DailyTaskComponent} from './component/daily-tasks/daily-task/daily-task.component';
import {RegisterComponent} from './component/register/register.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RegisterDialogComponent} from './component/dialog/register-dialog/register-dialog.component';
import {authInterceptorProviders} from './interceptor/auth.interceptor';
import {LoginComponent} from './component/login/login.component';
import {LoginDialogComponent} from './component/dialog/login-dialog/login-dialog.component';
import {CalendarComponent} from './component/calendar/calendar.component';
import {ProfileComponent} from './component/profile/profile.component';
import {DailyTaskCreateComponent} from './component/daily-tasks/daily-task-create/daily-task-create.component';
import {MatSelectModule} from '@angular/material/select';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    DailyTasksComponent,
    WeeklyTasksComponent,
    DailyTaskComponent,
    RegisterComponent,
    RegisterDialogComponent,
    LoginComponent,
    LoginDialogComponent,
    CalendarComponent,
    ProfileComponent,
    DailyTaskCreateComponent,
  ],
  imports: [
    AppMaterialModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    HttpClientModule,
    LayoutModule,
    FormsModule,
    ReactiveFormsModule,
    MatSelectModule,
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
