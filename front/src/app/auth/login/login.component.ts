import { Component, OnInit } from '@angular/core';
import { User } from "../models/model.user";
import { Router } from "@angular/router";
import { AuthenticationService } from "../services/authentication.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email = ''
  password = ''
  invalidLogin = false
  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }
  checkLogin() {
    (this.loginservice.authenticate(this.email, this.password).subscribe(
      data => {
        this.router.navigate([''])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true
      }
    ));
  }
}
