import { Injectable, EventEmitter } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class ModalService {
  modal: boolean = false;
  modalDetail: boolean = false;
  constructor() { }
  
  openModalBasic() {
    this.modal = true;
  }

  closeModalBasic() {
    this.modal = false;
  }

  openModalDetail() {
    this.modalDetail = true;
  }

  closeModalDetail() {
    this.modalDetail = false;
  }
}
