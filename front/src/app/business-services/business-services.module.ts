import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListServicesComponent } from './list-services/list-services.component';
import { AddServicesComponent } from './add-services/add-services.component';
import { UpdateServicesComponent } from './update-services/update-services.component';
import { DeleteServicesComponent } from './delete-services/delete-services.component';

@NgModule({
  declarations: [ListServicesComponent, AddServicesComponent, UpdateServicesComponent, DeleteServicesComponent],
  imports: [
    CommonModule
  ],
  exports:[
    ListServicesComponent,
    AddServicesComponent, 
    UpdateServicesComponent,
    DeleteServicesComponent,
  ],
})
export class BusinessServicesModule { }
