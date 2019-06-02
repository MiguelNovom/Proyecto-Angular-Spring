import { Injectable, EventEmitter } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class ModalService {

  modal: boolean = false;
  modalDetail: boolean = false;
  private _emitter = new EventEmitter<any>();
  constructor() { }

  get emitter():EventEmitter<any> {
    return this._emitter;
  }
  
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
