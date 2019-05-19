import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { LoginService } from 'src/app/auth/services/login.service';
import { Router } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-sidenav-list',
  templateUrl: './sidenav-list.component.html',
  styleUrls: ['./sidenav-list.component.css']
})
export class SidenavListComponent implements OnInit {

  @Output() sidenavClose = new EventEmitter();

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  public onSidenavClose = () => {
    this.sidenavClose.emit();
  }
  logout(): void {
    this.loginService.logout();
    swal.fire('Logout', 'Has cerrado sesión correctamente.', 'success');
    this.router.navigate(['/login']);
  }
}
