import { Component, OnInit } from '@angular/core';
import { User } from '../models/model.user';
import swal from 'sweetalert2';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  titulo: String = "Iniciar Sesion";
  user: User;
  constructor(private loginService: LoginService, private router: Router) {
    this.user = new User;
  }

  ngOnInit() {
    if (this.loginService.isAuthenticated()) {
      swal.fire('Iniciar Sesión', `Hola ${this.loginService.user.nombre} ya has iniciado sesión.`, 'info');
      this.router.navigate(['/home']);
    }
  }
  login(): void {
    if (this.user.email == "" || this.user.password == "") {
      swal.fire('Error al Iniciar Sesión', 'Los campos email y contraseña no pueden estar vacios', 'error');
      return;
    }
    this.loginService.login(this.user).subscribe(data => {
      this.loginService.saveUser(data.access_token);
      this.loginService.saveToken(data.access_token);
      this.router.navigate(['/home']);
      swal.fire('Iniciar Sesión', 'Has iniciado sesión correctamente.', 'success');
    }, error => {
      if (error.status == 400) {
        swal.fire('Error al Iniciar Sesión', 'Usuario o contraseña son incorrectas.', 'error');
      }
    });
  }
}
