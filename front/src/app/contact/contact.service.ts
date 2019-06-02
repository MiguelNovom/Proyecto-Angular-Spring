import { Injectable } from '@angular/core';
import { Contact } from './models/contact';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private urlEndPoint: string = 'http://localhost:8080/api/sendmail';
  constructor(private http: HttpClient) { }

  sendMail(mensaje: Contact): Observable<Contact> {
    console.log(mensaje);
    return this.http.post<Contact>(this.urlEndPoint, mensaje);
  }
}
