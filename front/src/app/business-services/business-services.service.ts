import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { LoginService } from '../auth/services/login.service';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { Servicios } from './models/servicios';
import { catchError } from 'rxjs/operators';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class BusinessServicesService {

  private urlEndPoint: string = 'http://localhost:8080/api/servicios';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient, private loginService: LoginService, private router: Router, ) { }

  private agregarAuthorizationHeader() {
    let token = this.loginService.token;
    if (token != null) {
      return this.httpHeaders.append('Authorization', 'Bearer ' + token);
    }
    return this.httpHeaders;
  }

  getServicios(): Observable<Servicios[]> {
    return this.http.get<Servicios[]>(this.urlEndPoint);
  }

  addServices(service: Servicios): Observable<Servicios> {
    return this.http.post<Servicios>(this.urlEndPoint, service, { headers: this.agregarAuthorizationHeader() })
  }

  getService(id: number): Observable<Servicios> {
    return this.http.get<Servicios>(`${this.urlEndPoint}/${id}`);
  }

  suscribeService(email: String, serv: Servicios): Observable<any> {
    return this.http.put<any>(`${this.urlEndPoint}/suscribe/${email}`, serv, { headers: this.agregarAuthorizationHeader() }).pipe(
      catchError(e => {
        Swal.fire('Error al suscribirse', e.error.mensaje, 'error');
        return throwError(e);
      }));
  }

  updateService(service: Servicios): Observable<any> {
    return this.http.put<Servicios>(`${this.urlEndPoint}/${service.id}`, service, { headers: this.agregarAuthorizationHeader() });
  }

  deleteService(id: number): Observable<void> {
    return this.http.delete<void>(`${this.urlEndPoint}/${id}`, { headers: this.agregarAuthorizationHeader() });
  }
}
