import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './parts/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { ListNoticesComponent } from './notices/list-notice/list-notices.component';
import { ListServicesComponent } from './business-services/list-services/list-services.component';
import { ContactComponent } from './contact/contact/contact.component';
import { DetailNoticeComponent } from './notices/detail-notice/detail-notice.component';
import { InformationComponent } from './parts/information/information.component';
import { RegisterComponent } from './auth/register/register.component';
import { ListSuscribeUsersComponent } from './suscribe-users/list-suscribe-users/list-suscribe-users.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'blog', component: ListNoticesComponent},
  { path: 'services', component: ListServicesComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'blog/ver/:id', component: DetailNoticeComponent},
  { path: 'info', component: InformationComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'users_suscribed', component: ListSuscribeUsersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
