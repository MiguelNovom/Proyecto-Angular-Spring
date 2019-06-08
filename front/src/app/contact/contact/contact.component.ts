import { Component, OnInit } from '@angular/core';
import { Contact } from '../models/contact';
import { ContactService } from '../contact.service';
import Swal from 'sweetalert2';
import { LoginService } from 'src/app/auth/services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contact: Contact;
  constructor(private contactService: ContactService, private loginService: LoginService, private router: Router) {
    this.contact = <Contact>{};
  }

  ngOnInit() {
  }
  sendMail(): void {
    if (this.loginService.isAuthenticated()) {
      this.contact.mail = this.loginService.getTokenData(this.loginService.token).user_name
      this.contact.nombre = this.loginService.user.nombre;
      this.contactService.sendMail(this.contact).subscribe(
        data => {
          Swal.fire('Mensaje', data.mensaje, 'success');
        },
      );
    } else {
      Swal.fire('Aviso', 'Necesitas  iniciar sesión para enviar un mensaje.', 'warning');
      this.router.navigate(['/login']);
    }

  }

}
