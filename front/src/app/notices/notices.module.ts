import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListNoticesComponent } from './list-notice/list-notices.component';
import { AddNoticeComponent } from './add-notice/add-notice.component';
import { DetailNoticeComponent } from './detail-notice/detail-notice.component';
import { MatCardModule, MatButtonModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { NoticeFilterPipe } from './pipes/notice-filter.pipe';

@NgModule({
  declarations: [ListNoticesComponent, AddNoticeComponent, DetailNoticeComponent, NoticeFilterPipe],
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule,
    FormsModule,
    AppRoutingModule,
  ],
  exports: [
    ListNoticesComponent,
    AddNoticeComponent,
    DetailNoticeComponent,
    MatCardModule,
    MatButtonModule,
    FormsModule,
    AppRoutingModule,
    NoticeFilterPipe,
  ],
})
export class NoticesModule { }
