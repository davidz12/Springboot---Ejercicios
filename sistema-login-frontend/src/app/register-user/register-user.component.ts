import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
    this.userService.registerUser(this.user).subscribe(dato => {
      console.log(dato);
      this.goToTheUserList();
    });
  }

  goToTheUserList(){
    this.router.navigate(['/users']);
  }

  onSumbit(){
    this.saveUser();
  }

}
