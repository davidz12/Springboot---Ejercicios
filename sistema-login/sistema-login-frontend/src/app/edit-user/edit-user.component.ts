import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { switchAll } from 'rxjs';
import swal from 'sweetalert2';
import { UserService } from '../user.service';
import { Usuario } from '../usuario';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent {

  id:number;
  user:Usuario = new Usuario();

  constructor(private userService:UserService,private router:Router,private route:ActivatedRoute){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.userService.getUser(this.id).subscribe(dato =>{
      this.user = dato;
    });
  }

  goToTheUserList(){
    this.router.navigate(['/users']);
    
  }

  onSumbit(){
    swal({
      title: "¿Estas seguro que deseas editar este usuario?",
      text: "Confirma si deseas editar el usuario",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      confirmButtonText: "Si, editar",
      cancelButtonText: "No, no editar",
      confirmButtonClass: "btn btn-success",
      cancelButtonClass: "btn btn-danger",
      buttonsStyling: true
    }).then((result) => { if (result.value){
    this.userService.editUser(this.id,this.user).subscribe(dato => {
      console.log(dato);
      this.goToTheUserList();
      swal(
        "Usuario editado",
        "El usuario ha sido editado con exito",
        'success'
      );
    });
   }
  })
  }  
}
