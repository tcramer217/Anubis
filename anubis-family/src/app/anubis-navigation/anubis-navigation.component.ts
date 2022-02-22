import {Component} from '@angular/core';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {Observable} from 'rxjs';
import {map, shareReplay} from 'rxjs/operators';
import {MatDialog} from '@angular/material/dialog';
import {RegisterDialogComponent} from '../register/register-dialog.component';
import {LoginDialogComponent} from '../login/login-dialog/login-dialog.component';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-anubis-navigation',
  templateUrl: './anubis-navigation.component.html',
  styleUrls: ['./anubis-navigation.component.less']
})
export class AnubisNavigationComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  isLoggedIn: boolean = false;

  constructor(
    private breakpointObserver: BreakpointObserver,
    private dialog: MatDialog,
    private tokenService: TokenStorageService
  ) {
    let user = this.tokenService.getUser();
    console.log('user', user);
    this.isLoggedIn = tokenService.getUser() !== {};
  }

  openRegisterDialog(): void {
    const dialogRef = this.dialog.open(RegisterDialogComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed:', result);
    });
  }

  openLoginDialog(): void {
    const dialogRef = this.dialog.open(LoginDialogComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed:', result);
    });
  }
}
