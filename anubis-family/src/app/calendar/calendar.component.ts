import { Component, OnInit } from '@angular/core';
import {TestService} from "../service/test.service";

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.less']
})
export class CalendarComponent implements OnInit {

  constructor(
    private testService: TestService
  ) { }

  ngOnInit(
  ): void {
    console.log('Getting Content...');
    const pubContent   = this.testService.getPublicContent();
    const userContent  = this.testService.getUserBoard();
    const modContent   = this.testService.getModeratorBoard();
    const adminContent = this.testService.getAdminBoard();
    pubContent.subscribe(result => console.log('pubContent result:', result));
    userContent.subscribe(result => console.log('userContent result:', result))
    modContent.subscribe(result => console.log('modContent result:', result))
    adminContent.subscribe(result => console.log('adminContent result:', result))
  }

}
