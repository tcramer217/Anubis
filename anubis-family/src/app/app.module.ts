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

@NgModule({
  declarations: [
    AppComponent,
    AnubisNavigationComponent,
    AnubisDailyTasksComponent,
    AnubisWeeklyTasksComponent
  ],
  imports: [
    AppMaterialModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    HttpClientModule,
    LayoutModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
