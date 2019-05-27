import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Noticias } from './models/noticias';
import { LoginService } from '../auth/services/login.service';

@Injectable({
  providedIn: 'root'
})
export class NoticeService {
  private urlEndPoint: string = 'http://localhost:8080/api/noticias';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private loginService: LoginService, private router: Router, ) { }

  private agregarAuthorizationHeader() {
    let token = this.loginService.token;
    if (token != null) {
      return this.httpHeaders.append('Authorization', 'Bearer ' + token);
    }
    return this.httpHeaders;
  }

  getNotices(): Observable<Noticias[]> {
    return this.http.get<Noticias[]>(this.urlEndPoint);
  }

  addNotices(notice: Noticias): Observable<Noticias> {
    return this.http.post<Noticias>(this.urlEndPoint, notice, { headers: this.agregarAuthorizationHeader() })
  }

  getNotice(id: number): Observable<Noticias> {
    return this.http.get<Noticias>(`${this.urlEndPoint}/${id}`);
  }

  update(notice: Noticias): Observable<any> {
    return this.http.put<Noticias>(`${this.urlEndPoint}/${notice.id}`, notice, { headers: this.agregarAuthorizationHeader() });
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.urlEndPoint}/${id}`, { headers: this.agregarAuthorizationHeader() });
  }


  uploadPhoto(archivo: File, id): Observable<HttpEvent<{}>> {

    let formData = new FormData();
    formData.append("archivo", archivo);
    formData.append("id", id);

    let httpHeaders = new HttpHeaders();
    let token = this.loginService.token;
    if (token != null) {
      httpHeaders = httpHeaders.append('Authorization', 'Bearer ' + token);
    }

    const req = new HttpRequest('POST', `${this.urlEndPoint}/upload`, formData, {
      reportProgress: true,
      headers: httpHeaders
    });

    return this.http.request(req);
  }
}
