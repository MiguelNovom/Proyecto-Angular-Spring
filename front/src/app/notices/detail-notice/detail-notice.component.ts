import { Component, OnInit } from '@angular/core';
import { Noticias } from '../models/noticias';
import Swal from 'sweetalert2';
import { NoticeService } from '../notice.service';
import { LoginService } from 'src/app/auth/services/login.service';
import { HttpEventType } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-detail-notice',
  templateUrl: './detail-notice.component.html',
  styleUrls: ['./detail-notice.component.css']
})
export class DetailNoticeComponent implements OnInit {

  titulo: String = "Detalle Noticia";
  notice: Noticias;
  private selectedPhoto: File;
  progressBar: number = 0;
  detailVision: Boolean;

  constructor(private noticeService: NoticeService,
    private loginService: LoginService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.detailVision = false;
    this.activatedRoute.paramMap.subscribe(params => {
      let id = +params.get('id');
      this.noticeService.getNotice(id).subscribe(notice => this.notice = notice);
    });
  }

  selectPhoto(event) {
    this.selectedPhoto = event.target.files[0];
    this.progressBar = 0;
    if (this.selectedPhoto.type.indexOf('image') < 0) {
      Swal.fire('Error al seleccionar la imagen: ', 'El archivo debe ser una imagen', 'error');
      this.selectedPhoto = null;
    }
  }

  uploadPhoto() {
    if (!this.selectedPhoto) {
      Swal.fire('Error en la subida: ', 'Debe seleccionar una foto', 'error');
    } else {
      this.noticeService.uploadPhoto(this.selectedPhoto, this.notice.id)
        .subscribe(event => {
          if (event.type === HttpEventType.UploadProgress) {
            this.progressBar = Math.round((event.loaded / event.total) * 100);
          } else if (event.type === HttpEventType.Response) {
            let response: any = event.body;
            this.notice = response.noticia as Noticias;
            Swal.fire('La foto se ha subido completamente!', response.mensaje, 'success');
          }
        });
    }
  }
  delete(noti: Noticias): void {
    Swal.fire({
      title: 'Estas seguro?',
      text: `¿Seguro que desea eliminar la noticia ${noti.titulo}?`,
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
        this.noticeService.delete(noti.id).subscribe(
          () => {
            this.router.navigate(['/blog/']);
            Swal.fire('Servicio Eliminado', 'Servicio eliminado correctamente!', 'success');
          }
        )
      }
    });
  }
  changeView(): void {
    if (this.detailVision) {
      this.detailVision = false;
    } else {
      this.detailVision = true;
    }
  }

  update(): void {
    this.noticeService.update(this.notice)
      .subscribe(
        data => {
          Swal.fire('Noticia Actualizada', `${data.mensaje}`, 'success');
        },
      )
  }

}
