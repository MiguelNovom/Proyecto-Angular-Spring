import { Component, OnInit } from '@angular/core';
import { NoticeService } from '../notice.service';
import { ActivatedRoute } from '@angular/router';
import { Noticias } from '../models/noticias';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-list-notices',
  templateUrl: './list-notices.component.html',
  styleUrls: ['./list-notices.component.css']
})
export class ListNoticesComponent implements OnInit {

  notices: Noticias[];
  paginator: any;

  constructor(private noticeService: NoticeService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      let page: number = +params.get('page');
      if (!page) {
        page = 0;
      }

      this.noticeService.getNotices(page)
        .pipe(
          tap(response => {
            (response.content as Noticias[]).forEach(data => console.log(data.titulo));
          })
        ).subscribe(response => {
          this.notices = response.content as Noticias[];
          this.paginator = response;
        });
    });
  }

}
