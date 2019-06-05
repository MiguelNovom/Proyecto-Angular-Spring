import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  titulo: String = "Registro";
  user: User;
  constructor(private loginService: LoginService, private router: Router) {
    this.user = new User;
  }

  ngOnInit() {
  }


  addUser(): void {
    this.loginService.register(this.user).subscribe(
      data => {
        this.loginService.login(data.usuario).subscribe(acc => {
          this.loginService.saveUser(acc.access_token);
          this.loginService.saveToken(acc.access_token);
          Swal.fire('Registro', 'Se ha registrado en el sistema correctamente.', 'success');
          this.router.navigate(['/home']);
        });
        
      },
    );
  }

}
