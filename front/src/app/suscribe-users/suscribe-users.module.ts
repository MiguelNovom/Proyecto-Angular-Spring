import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListSuscribeUsersComponent } from './list-suscribe-users/list-suscribe-users.component';
import { MatTableModule } from "@angular/material";

@NgModule({
  declarations: [ListSuscribeUsersComponent],
  imports: [
    CommonModule,
    MatTableModule
  ],
  exports:[ListSuscribeUsersComponent, MatTableModule]
})
export class SuscribeUsersModule { }
