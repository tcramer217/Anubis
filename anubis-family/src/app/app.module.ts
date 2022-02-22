import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppMaterialModule} from './app-material.module';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';

import {LayoutModule} from '@angular/cdk/layout';

import {AnubisNavigationComponent} from './anubis-navigation/anubis-navigation.component';
import {AnubisDailyTasksComponent} from './anubis-daily-tasks/anubis-daily-tasks.component';
import {AnubisWeeklyTasksComponent} from './anubis-weekly-tasks/anubis-weekly-tasks.component';
import {HttpClientModule} from '@angular/common/http';
import {DailyTaskComponent} from './anubis-daily-tasks/daily-task/daily-task.component';
import {RegisterComponent} from './register/register.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {RegisterDialogComponent} from './register/register-dialog.component';
import {authInterceptorProviders} from './interceptor/auth.interceptor';
import {LoginComponent} from './login/login.component';
import {LoginDialogComponent} from './login/login-dialog/login-dialog.component';
import { CalendarComponent } from './calendar/calendar.component';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    AnubisNavigationComponent,
    AnubisDailyTasksComponent,
    AnubisWeeklyTasksComponent,
    DailyTaskComponent,
    RegisterComponent,
    RegisterDialogComponent,
    LoginComponent,
    LoginDialogComponent,
    CalendarComponent,
    ProfileComponent,
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
    MatFormFieldModule,
    MatInputModule,
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
