import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTabsModule, MatSidenavModule, MatToolbarModule, MatIconModule, MatButtonModule, MatListModule } from '@angular/material';
import { HeaderComponent } from './navigation/header/header.component';
import { LayoutComponent } from './layout/layout.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { SidenavListComponent } from './navigation/sidenav-list/sidenav-list.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { FooterComponent } from './footer/footer.component';


@NgModule({
  declarations: [HeaderComponent, LayoutComponent, SidenavListComponent, HomeComponent, FooterComponent],
  imports: [
    FlexLayoutModule,
    CommonModule,
    MatTabsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    RouterModule,
  ],
  exports: [
    HomeComponent,
    FlexLayoutModule,
    LayoutComponent,
    HeaderComponent,
    SidenavListComponent,
    MatTabsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    RouterModule,
  ],
})
export class PartsModule { }
