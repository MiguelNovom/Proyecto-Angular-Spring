import { Component, OnInit, Input } from '@angular/core';
import { ModalService } from 'src/app/notices/modal.service';
import { Servicios } from '../models/servicios';
import { BusinessServicesService } from '../business-services.service';
import Swal from 'sweetalert2';
import { LoginService } from 'src/app/auth/services/login.service';

export interface Icons {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-detail-service',
  templateUrl: './detail-service.component.html',
  styleUrls: ['./detail-service.component.css']
})

export class DetailServiceComponent implements OnInit {

  @Input() service: Servicios;
  tittle: String = "Detalle del Servicio";
  icons: Icons[] = [
    { value: 'account_balance', viewValue: 'Banco' },
    { value: 'assessment', viewValue: 'Estadisticas' },
    { value: 'euro_symbol', viewValue: 'Euro' },
    { value: 'flight_takeof', viewValue: 'Avion' },
    { value: 'gavel', viewValue: 'Martillo' },
    { value: 'info', viewValue: 'Info' },
    { value: 'supervised_user_circle', viewValue: 'Supervisor' },
    { value: 'thumb_up', viewValue: 'Mano Arriba' },
    { value: 'business', viewValue: 'Empresa' },
    { value: 'ring_volume', viewValue: 'Telefono' },
    { value: 'next_week', viewValue: 'Maleta' },
    { value: 'local_post_office', viewValue: 'Mail' },
    { value: 'business_center', viewValue: 'Maleta 2' },
    { value: 'notifications', viewValue: 'Notficacion' },
    { value: 'school', viewValue: 'Escuela' },
    { value: 'public', viewValue: 'Mundo' },
    { value: '3d_rotation', viewValue: 'Rotacion 3D' },
    { value: 'book', viewValue: 'Libro' },
    { value: 'done', viewValue: 'Terminado' },
    { value: 'android', viewValue: 'Android' },
  ];
  constructor(private modalService: ModalService, private bsService: BusinessServicesService,
     private loginService:LoginService) { }

  ngOnInit() {
  }

  closeModal() {
    this.modalService.closeModalDetail();
  }
 
  updateService(): void {
    this.bsService.updateService(this.service)
      .subscribe(
        data => {
          Swal.fire('Servicio Actualizado', `${data.mensaje}`, 'success');
          this.closeModal();
        },
      )
  }
  suscribeService(serv:Servicios):void {
    this.bsService.suscribeService(this.loginService.getTokenData(this.loginService.token).user_name, serv).subscribe(
      data=>{
        Swal.fire('Servicio Actualizado', data.mensaje, 'success');
        this.closeModal();
      }
    )
  }

}
