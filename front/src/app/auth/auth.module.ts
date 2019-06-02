import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { FormsModule } from '@angular/forms'
import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material';
import { HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [LoginComponent, RegisterComponent, ProfileComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    MatButtonModule,
  ],
  exports: [
    FormsModule,
    RouterModule,
    HttpClientModule,
    MatButtonModule,
  ]
})
export class AuthModule { }
