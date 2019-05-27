import { Component, OnInit } from '@angular/core';
import { ModalService } from '../modal.service';
import Swal from 'sweetalert2';
import { LoginService } from 'src/app/auth/services/login.service';
import { Noticias } from '../models/noticias';
import { NoticeService } from '../notice.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-notice',
  templateUrl: './add-notice.component.html',
  styleUrls: ['./add-notice.component.css']
})
export class AddNoticeComponent implements OnInit {

  tittle:String = "Crear Noticas";
  notice:Noticias;

  constructor(private modalService:ModalService, private loginService:LoginService,
    private noticeService:NoticeService, private router:Router) {
    this.notice= <Noticias>{};
   }
  ngOnInit() {
  }

  addNotices():void {
    this.noticeService.addNotices(this.notice).subscribe(
      data => {
        this.closeModal();
        Swal.fire('Noticia creada', 'Noticia creada satisfactoriamente', 'success');
        this.router.navigate(['/blog/ver/',data.id]);
      },
    );
  }

  closeModal() {
    this.modalService.closeModal();
  }
}
