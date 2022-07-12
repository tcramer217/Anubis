import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Profile} from '../../../model/profile';

@Component({
  selector: 'app-task-create',
  templateUrl: './task-create.component.html',
  styleUrls: ['./task-create.component.less']
})
export class TaskCreateComponent implements OnInit {
  familyMembers: Profile[] = [];

  constructor(
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({familyMembers}) => {
      this.familyMembers = familyMembers;
    })
  }

}
