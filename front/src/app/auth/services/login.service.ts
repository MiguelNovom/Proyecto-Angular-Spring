import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import Swal from 'sweetalert2';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private _user: User;
  private _token: string;


  constructor(private http: HttpClient, private router:Router) { }

  public get user(): User {
    if (this._user != null) {
      return this._user;
    } else if (this._user == null && sessionStorage.getItem('user') != null) {
      this._user = JSON.parse(sessionStorage.getItem('user')) as User;
      return this._user;
    }
    return new User();
  }


  public get token(): string {
    if (this._token != null) {
      return this._token;
    } else if (this._token == null && sessionStorage.getItem('token') != null) {
      this._token = sessionStorage.getItem('token');
      return this._token;
    }
    return null;
  }

  login(user: User): Observable<any> {
    const urlEndpoint = 'http://localhost:8080/oauth/token';

    const credenciales = btoa('angularapp' + ':' + '12345');
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Authorization': 'Basic ' + credenciales
    });
    let params = new URLSearchParams();
    params.set('grant_type', 'password');
    params.set('username', user.email);
    params.set('password', user.password);
    return this.http.post<any>(urlEndpoint, params.toString(), { headers: httpHeaders })
  }

  getsuscribedUsers(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/api/users/suscribed');
  }

  saveUser(accessToken: string): void {
    let payload = this.getTokenData(accessToken);
    this._user = new User();
    this._user.nombre = payload.nombre;
    this._user.apellidos = payload.apellidos;
    this._user.email = payload.email;
    this._user.telefono = payload.telefono;
    this._user.roles = payload.authorities;
    sessionStorage.setItem('user', JSON.stringify(this._user));
  }

  register(user: User): Observable<any> {
    return this.http.post('http://localhost:8080/api/register', user).pipe(
      catchError(e=>{
        Swal.fire('Error al registrarse',e.error.mensaje,'error');
        return throwError(e);
      })
     
    );
  }

  getUserLogged(): User{
    this._user = JSON.parse(sessionStorage.getItem('user')) as User;
    return this._user;
  }

  getTokenData(accessToken: string): any {
    if (accessToken != null) {
      return JSON.parse(atob(accessToken.split(".")[1]));
    }
    return null;
  }

  saveToken(accessToken: string): void {
    this._token = accessToken;
    sessionStorage.setItem('token', accessToken);
  }

  isAuthenticated(): boolean {
    let payload = this.getTokenData(this.token);
    if (payload != null && payload.user_name && payload.user_name.length > 0) {
      return true;
    }
    return false;
  }

  hasRole(role: string): boolean {
    if (this.user.roles.includes(role)) {
      return true;
    }
    return false;
  }
  logout(): void {
    this._token = null;
    this._user = null;
    sessionStorage.clear();
  }
}
