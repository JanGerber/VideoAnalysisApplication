import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {shareReplay, tap} from 'rxjs/operators';
import {AuthResponse} from '../models/auth-response';
import {JwtHelperService} from '@auth0/angular-jwt';
import {MatSnackBar} from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  jwtHelper = new JwtHelperService();
  public newLogin = new EventEmitter<boolean>();

  constructor(private http: HttpClient,
              private snackBar: MatSnackBar) {
  }

  login(username: string, password: string) {
    return this.http.post<AuthResponse>('/api/v1/login', {username, password}).pipe(
      tap(res => {
        this.setSession(res.jwt);
        this.newLogin.emit(true);
        this.snackBar.open(`Sie wurden erfolgreich eingeloggt`,
          '',
          {
            panelClass: ['bg-success']
          });
      }, error => {
        this.snackBar.open(`Sie konnten nicht eingelogt werden (${error.status}): ${error.message}`,
          '',
          {
            panelClass: ['bg-warning', 'text-dark']
          });
      }),
      shareReplay()
    )
  }

  logout() {
    localStorage.removeItem("token");
  }

  public isLoggedIn() {
    return !this.jwtHelper.isTokenExpired(localStorage.getItem("token"));
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

  private setSession(token: string) {
    localStorage.setItem('token', token);
  }
}
