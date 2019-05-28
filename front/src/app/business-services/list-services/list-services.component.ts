import { Component, OnInit } from '@angular/core';
import { Servicios } from '../models/servicios';
import { BusinessServicesService } from '../business-services.service';
import { LoginService } from 'src/app/auth/services/login.service';
import { ModalService } from 'src/app/notices/modal.service';

@Component({
  selector: 'app-list-services',
  templateUrl: './list-services.component.html',
  styleUrls: ['./list-services.component.css']
})
export class ListServicesComponent implements OnInit {

  servicios: Servicios[];
  constructor(private bsServicio: BusinessServicesService,
    private loginService: LoginService, private modalService: ModalService) { }

  ngOnInit() {
    this.bsServicio.getServicios().subscribe(data => {
      this.servicios = data;
    });
  }
  openModal() {
    this.modalService.openModal();
  }

}
