import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { LoginService } from 'src/app/auth/services/login.service';
import swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Output() public sidenavToggle = new EventEmitter();
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }
  public onToggleSidenav = () => {
    this.sidenavToggle.emit();
  }

  logout(): void {
    this.loginService.logout();
    swal.fire('Logout', 'Has cerrado sesión correctamente.', 'success');
    this.router.navigate(['/login']);
  }
}
