import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule, MatButtonModule, MatSelectModule, MatTooltipModule } from '@angular/material';
import { ListServicesComponent } from './list-services/list-services.component';
import { AddServicesComponent } from './add-services/add-services.component';
import { UpdateServicesComponent } from './update-services/update-services.component';
import { FormsModule } from '@angular/forms';
import { DetailServiceComponent } from './detail-service/detail-service.component';


@NgModule({
  declarations: [ListServicesComponent, AddServicesComponent, UpdateServicesComponent, DetailServiceComponent],
  imports: [
    CommonModule,
    MatIconModule,
    MatButtonModule,
    FormsModule,
    MatSelectModule,
    MatTooltipModule,
  ],
  exports: [
    ListServicesComponent,
    MatIconModule,
    AddServicesComponent,
    UpdateServicesComponent,
    MatButtonModule,
    FormsModule,
    MatTooltipModule,
    MatSelectModule,
  ],
})
export class BusinessServicesModule { }
