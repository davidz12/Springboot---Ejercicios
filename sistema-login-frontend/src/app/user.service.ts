import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from './usuario';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  //Esta URL obtiene el listado de todos los usuarios en el backend.
  private baseUrl = "http://localhost:8080/users/list";

  constructor(private httpClient : HttpClient) { }

  //Metodo que obtiene los empleados
  getUsersList():Observable<Usuario[]>{
    return this.httpClient.get<Usuario[]>(`${this.baseUrl}`);
  }

}
