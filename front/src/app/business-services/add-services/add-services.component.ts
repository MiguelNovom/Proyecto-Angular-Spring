import { Component, OnInit } from '@angular/core';
import { BusinessServicesModule } from '../business-services.module';
import { BusinessServicesService } from '../business-services.service';
import { ModalService } from 'src/app/notices/modal.service';
import Swal from 'sweetalert2';
import { Servicios } from '../models/servicios';

export interface Icons {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-add-services',
  templateUrl: './add-services.component.html',
  styleUrls: ['./add-services.component.css']
})
export class AddServicesComponent implements OnInit {

  tittle: String = "Crear Servicios";
  service: Servicios;
  icons: Icons[] = [
    {value: 'account_balance', viewValue: 'Banco'},
    {value: 'assessment', viewValue: 'Estadisticas'},
    {value: 'euro_symbol', viewValue: 'Euro'},
    {value: 'flight_takeof', viewValue: 'Avion'},
    {value: 'gavel', viewValue: 'Martillo'},
    {value: 'info', viewValue: 'Info'},
    {value: 'supervised_user_circle', viewValue: 'Supervisor'},
    {value: 'thumb_up', viewValue: 'Mano Arriba'},
    {value: 'business', viewValue: 'Empresa'},
    {value: 'ring_volume', viewValue: 'Telefono'},
    {value: 'next_week', viewValue: 'Maleta'},
    {value: 'local_post_office', viewValue: 'Mail'},
    {value: 'business_center', viewValue: 'Maleta 2'},
    {value: 'notifications', viewValue: 'Notficacion'},
    {value: 'school', viewValue: 'Escuela'},
    {value: 'public', viewValue: 'Mundo'},
    {value: '3d_rotation', viewValue: 'Rotacion 3D'},
    {value: 'book', viewValue: 'Libro'},
    {value: 'done', viewValue: 'Terminado'},
    {value: 'android', viewValue: 'Android'},
  ];

  constructor(private sbService: BusinessServicesService, private modalService: ModalService, ) {
    this.service = <Servicios>{};
  }

  ngOnInit() {
  }
  
  addService(): void {
    this.sbService.addServices(this.service).subscribe(
      data => {
        this.closeModal();
        Swal.fire('Servicio creado', 'Servicio creado satisfactoriamente', 'success');
        this.modalService.emitter.emit(data);
      },
    );
  }

  closeModal() {
    this.modalService.closeModalBasic();
  }

}
