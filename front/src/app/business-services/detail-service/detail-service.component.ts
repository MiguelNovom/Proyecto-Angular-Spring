import { Component, OnInit } from '@angular/core';
import { ModalService } from 'src/app/notices/modal.service';

@Component({
  selector: 'app-detail-service',
  templateUrl: './detail-service.component.html',
  styleUrls: ['./detail-service.component.css']
})
export class DetailServiceComponent implements OnInit {
  tittle:String = "Servicio";
  constructor(private modalService:ModalService) { }

  ngOnInit() {
  }

  closeModal(){
    this.modalService.closeModalDetail();
  }

}
