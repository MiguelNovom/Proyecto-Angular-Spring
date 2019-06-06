import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PartsModule } from './parts/parts.module';
import { AuthModule } from './auth/auth.module';
import { NoticesModule } from './notices/notices.module';
import { ContactModule } from './contact/contact.module';
import { BusinessServicesModule } from './business-services/business-services.module';
import { SuscribeUsersModule } from './suscribe-users/suscribe-users.module';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    PartsModule,
    AuthModule,
    NoticesModule,
    ContactModule,
    BusinessServicesModule,
    SuscribeUsersModule,
  ],
 
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
