import {Component} from '@angular/core';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {Observable} from 'rxjs';
import {map, shareReplay} from 'rxjs/operators';
import {MatDialog} from '@angular/material/dialog';
import {RegisterDialogComponent} from '../dialog/register-dialog/register-dialog.component';
import {LoginDialogComponent} from '../dialog/login-dialog/login-dialog.component';
import {TokenStorageService} from '../../service/token-storage.service';
import {Router} from '@angular/router';
import {User} from '../../model/user';

@Component({
  selector: 'app-anubis-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.less']
})
export class NavigationComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  currentUser: User;
  familyName = 'Anubis';
  isLoggedIn = false;

  constructor(
    private breakpointObserver: BreakpointObserver,
    private dialog: MatDialog,
    private tokenService: TokenStorageService,
    private router: Router
  ) {
    this.currentUser = this.tokenService.getUser();
    this.familyName = this.tokenService.getProfile().lastName;
    console.log('familyName:', this.familyName);
    this.isLoggedIn = Object.keys(this.currentUser).length > 0;
  }

  openRegisterDialog(): void {
    const dialogRef = this.dialog.open(RegisterDialogComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed:', result);
      this.router.navigate(['/']);
    });
  }

  openLoginDialog(): void {
    const dialogRef = this.dialog.open(LoginDialogComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      // noop
      this.router.navigate(['/']);
    });
  }

  logout(): void {
    this.tokenService.signOut();
    this.isLoggedIn = false;
    this.router.navigate(['/']);

  }
}
