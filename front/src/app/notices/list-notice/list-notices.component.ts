import { Component, OnInit } from '@angular/core';
import { NoticeService } from '../notice.service';
import { ActivatedRoute } from '@angular/router';
import { Noticias } from '../models/noticias';
import { LoginService } from 'src/app/auth/services/login.service';
import { ModalService } from '../modal.service';

@Component({
  selector: 'app-list-notices',
  templateUrl: './list-notices.component.html',
  styleUrls: ['./list-notices.component.css']
})
export class ListNoticesComponent implements OnInit {

  notices: Noticias[];

  constructor(private noticeService: NoticeService,
    private loginService: LoginService, private modalService: ModalService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.noticeService.getNotices().subscribe(data => {
      this.notices = data;
    });
  }

  openModal() {
    this.modalService.openModal();
  }
}
