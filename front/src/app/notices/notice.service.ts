import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, tap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Noticias } from './models/noticias';

@Injectable({
  providedIn: 'root'
})
export class NoticeService {
  private urlEndPoint: string = 'http://localhost:8080/api/noticias';

  constructor(private http: HttpClient, private router: Router,) { }
  getNotices(page: number): Observable<any> {
    return this.http.get(this.urlEndPoint + '/page/' + page).pipe(
      tap((response: any) => {
        (response.content as Noticias[]).forEach(data => console.log(data.titulo));
      }),
      map((response: any) => {
        (response.content as Noticias[]).map(data => {
          data.titulo = data.titulo.toUpperCase();
          return data;
        });
        return response;
      }),
      tap(response => {
        console.log('ClienteService: tap 2');
        (response.content as Noticias[]).forEach(data => console.log(data.titulo));
      })
    );
  }
}
