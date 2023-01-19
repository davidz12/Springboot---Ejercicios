import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Usuario } from '../usuario';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {

  users:Usuario[];

  constructor(private userService:UserService){}

  ngOnInit(): void {
    this.getUsers();
  }

  private getUsers() {
    this.userService.getUsersList().subscribe(dato => {
      this.users = dato;
    });
  }

}
