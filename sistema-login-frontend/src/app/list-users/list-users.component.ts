import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { Usuario } from '../usuario';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {

  users:Usuario[];

  constructor(private userService:UserService,private router:Router){}

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    this.userService.getUsersList().subscribe(dato => {
      this.users = dato;
    });
  }

  editUser(id:number){
    this.router.navigate(['edit-user',id]);
  }

  deleteUser(id:number){
    this.userService.deleteUser(id).subscribe( dato => {
      this.getUsers();
    });
  }

  userDetails(id:number){
    this.router.navigate(['user-details',id]);
  }

  

}
