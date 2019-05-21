import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListNoticesComponent } from './list-notice/list-notices.component';
import { AddNoticeComponent } from './add-notice/add-notice.component';
import { UpdateNoticeComponent } from './update-notice/update-notice.component';
import { DeleteNoticeComponent } from './delete-notice/delete-notice.component';
import { DetailNoticeComponent } from './detail-notice/detail-notice.component';

@NgModule({
  declarations: [ListNoticesComponent, AddNoticeComponent, UpdateNoticeComponent, DeleteNoticeComponent, DetailNoticeComponent],
  imports: [
    CommonModule
  ], 
  exports:[
    ListNoticesComponent,
    AddNoticeComponent, 
    UpdateNoticeComponent,
    DeleteNoticeComponent,
    DetailNoticeComponent 
  ],
})
export class NoticesModule { }
