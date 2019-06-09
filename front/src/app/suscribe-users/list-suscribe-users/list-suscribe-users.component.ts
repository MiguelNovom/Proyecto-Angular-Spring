import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/auth/services/login.service';

@Component({
  selector: 'app-list-suscribe-users',
  templateUrl: './list-suscribe-users.component.html',
  styleUrls: ['./list-suscribe-users.component.css']
})
export class ListSuscribeUsersComponent implements OnInit {
  
  usersByServices = [];
  constructor(private loginService:LoginService) { }

  ngOnInit() {
    this.getsuscribedUsers();
  }
  public getsuscribedUsers () {
    this.loginService.getsuscribedUsers()
    .subscribe(res => {
      this.usersByServices = res;
    })
  }
  

}
