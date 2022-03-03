import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppMaterialModule} from './app-material.module';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';

import {LayoutModule} from '@angular/cdk/layout';

import {NavigationComponent} from './navigation/navigation.component';
import {DailyTasksComponent} from './daily-tasks/daily-tasks.component';
import {WeeklyTasksComponent} from './weekly-tasks/weekly-tasks.component';
import {HttpClientModule} from '@angular/common/http';
import {DailyTaskComponent} from './daily-tasks/daily-task/daily-task.component';
import {RegisterComponent} from './register/register.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RegisterDialogComponent} from './register/register-dialog.component';
import {authInterceptorProviders} from './interceptor/auth.interceptor';
import {LoginComponent} from './login/login.component';
import {LoginDialogComponent} from './login/login-dialog/login-dialog.component';
import {CalendarComponent} from './calendar/calendar.component';
import {ProfileComponent} from './profile/profile.component';
import {ProfileEditComponent} from './profile/profile-edit/profile-edit.component';
import {DailyTaskCreateComponent} from './daily-tasks/daily-task-create/daily-task-create.component';
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
    ProfileEditComponent,
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
