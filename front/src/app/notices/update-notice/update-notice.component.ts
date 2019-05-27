import { Component, OnInit, Input } from '@angular/core';
import Swal from 'sweetalert2';
import { NoticeService } from '../notice.service';
import { Noticias } from '../models/noticias';
import { HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-update-notice',
  templateUrl: './update-notice.component.html',
  styleUrls: ['./update-notice.component.css']
})
export class UpdateNoticeComponent implements OnInit {

  constructor(private noticeService:NoticeService) { }

  ngOnInit() {
  }

}
