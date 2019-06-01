import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListNoticesComponent } from './list-notice/list-notices.component';
import { AddNoticeComponent } from './add-notice/add-notice.component';
import { DetailNoticeComponent } from './detail-notice/detail-notice.component';
import { MatCardModule, MatButtonModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';

@NgModule({
  declarations: [ListNoticesComponent, AddNoticeComponent, DetailNoticeComponent],
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
  ],
})
export class NoticesModule { }
