import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private loginService: LoginService,
    private router: Router) { }

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError(e => {
        if (e.status == 401) {

          if (this.loginService.isAuthenticated()) {
            this.loginService.logout();
          }
          this.router.navigate(['/login']);
        }

        if (e.status == 403) {
          Swal.fire('Acceso denegado', `Hola ${this.loginService.user.nombre} no tienes acceso a este recurso!`, 'warning');
          this.router.navigate(['/home']);
        }
        return throwError(e);
      })
    );
  }
  
}
