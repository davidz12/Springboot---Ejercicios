import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import swal from 'sweetalert2';
import { UserService } from '../user.service';
import { Usuario } from '../usuario';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit{
  
  user:Usuario= new Usuario();

  constructor(private userService:UserService,private router:Router){}

  ngOnInit(): void {
    console.log(this.user)
  }


  saveUser() {
    swal({
      title: "¿Estas seguro que deseas registrar este usuario?",
      text: "Confirma si deseas registrar el usuario",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      confirmButtonText: "Si, registrar",
      cancelButtonText: "No, no registrar",
      confirmButtonClass: "btn btn-success",
      cancelButtonClass: "btn btn-danger",
      buttonsStyling: true
    }).then((result) => { if (result.value){
      this.userService.registerUser(this.user).subscribe(dato => {
        console.log(dato);
        this.goToTheUserList();
        swal(
          "Usuario registrado",
          "El usuario ha sido registrado con exito",
          'success'
        );
      });
    }
  })
  }

  goToTheUserList(){
    this.router.navigate(['/users']);
  }

  onSumbit(){
    this.saveUser();
  }

}

