import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { LoginService } from '../auth/services/login.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Servicios } from './models/servicios';

@Injectable({
  providedIn: 'root'
})
export class BusinessServicesService {

  private urlEndPoint: string = 'http://localhost:8080/api/servicios';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient, private loginService: LoginService, private router: Router,) { }
  
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
}
