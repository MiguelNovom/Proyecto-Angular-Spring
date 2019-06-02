import { Component, OnInit } from '@angular/core';
import { Servicios } from '../models/servicios';
import { BusinessServicesService } from '../business-services.service';
import { LoginService } from 'src/app/auth/services/login.service';
import { ModalService } from 'src/app/notices/modal.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-services',
  templateUrl: './list-services.component.html',
  styleUrls: ['./list-services.component.css']
})
export class ListServicesComponent implements OnInit {
  servicios: Servicios[];
  serviceSelected: Servicios;
  constructor(private bsService: BusinessServicesService,
    private loginService: LoginService, private modalService: ModalService,
    private router:Router) { }

  ngOnInit() {
    this.bsService.getServicios().subscribe(data => {
      this.servicios = data;
    });
    this.modalService.emitter.subscribe(data => {
      this.servicios.push(data);
    })
  }
  openModal() {
    this.modalService.openModalBasic();

  }
  openModalDetail(service: Servicios) {
    if(this.loginService.isAuthenticated()){
      this.serviceSelected = service;
      this.modalService.openModalDetail();
    }else{
      Swal.fire('Aviso', 'Necesitas  iniciar sesión para acceder a los servicios', 'warning');
      this.router.navigate(['/login']);
    }
  }

  deleteService(serv: Servicios): void {
    Swal.fire({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar el servicio ${serv.titulo}?`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar',
      cancelButtonText: 'Cancelar',
      confirmButtonClass: 'btn btn-success',
      cancelButtonClass: 'btn btn-danger',
      buttonsStyling: false,
      reverseButtons: false
    }).then((result) => {
      if (result.value) {
        this.bsService.deleteService(serv.id).subscribe(
          () => {
            this.servicios = this.servicios.filter(s => s !== serv)
            Swal.fire('Servicio Eliminado', 'Servicio eliminado correctamente!', 'success');
          }
        )
      }
    });
  }
}
