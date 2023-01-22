import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { Usuario } from '../usuario';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent {

  id:number;
  user:Usuario;

  constructor(private userService:UserService,private route:ActivatedRoute){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.user = new Usuario;
    this.userService.getUser(this.id).subscribe(dato=>{
      this.user = dato;
    });
  }
}
