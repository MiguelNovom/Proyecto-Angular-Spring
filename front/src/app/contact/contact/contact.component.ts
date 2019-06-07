import { Component, OnInit } from '@angular/core';
import { Contact } from '../models/contact';
import { ContactService } from '../contact.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contact:Contact;
  constructor(private contactService:ContactService) {
    this.contact = <Contact>{};
    this.contact.mail="e4b.novo23@gmail.com";
    this.contact.nombre="nombre";
   }

  ngOnInit() {
  }
  sendMail(): void {
    this.contactService.sendMail(this.contact).subscribe(
      data => {
        Swal.fire('Servicio creado', 'Servicio creado satisfactoriamente', 'success');
      },
    );
  }

}
