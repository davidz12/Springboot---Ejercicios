import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import swal from 'sweetalert2';
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
    swal({
      title: "¿Estas seguro que deseas eliminar el usuario?",
      text: "Confirma si deseas eliminar el usuario",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      confirmButtonText: "Si, eliminar",
      cancelButtonText: "No, no eliminar",
      confirmButtonClass: "btn btn-success",
      cancelButtonClass: "btn btn-danger",
      buttonsStyling: true
    }).then((result) => { if (result.value){
      this.userService.deleteUser(id).subscribe( dato => {
        this.getUsers();
        swal(
          "Usuario eliminado",
          "El usuario ha sido eliminado con exito",
          'success'
        );
      });
    } 
  })
    
  }

  userDetails(id:number){
    this.router.navigate(['user-details',id]);
  }

  

}
