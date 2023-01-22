import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from './usuario';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  //Esta URL obtiene el listado de todos los usuarios en el backend.
  private urlbase ="http://localhost:8080/api/users"
  private baseUrl = "http://localhost:8080/api/users/list";
  private url = "http://localhost:8080/api/users/delete"
  private url1 = "http://localhost:8080/api/users/edit"

  constructor(private httpClient : HttpClient) { }

  //Metodo que obtiene los empleados
  getUsersList():Observable<Usuario[]>{
    return this.httpClient.get<Usuario[]>(`${this.baseUrl}`);
  }

  //Metodo para registrar usuario
  registerUser(user:Usuario):Observable<Object>{
    return this.httpClient.post("http://localhost:8080/api/users/users", user);
  }

  getUser(id:number):Observable<Usuario>{
    return this.httpClient.get<Usuario>(`${this.urlbase}/${id}`);
  }

  deleteUser(id:number):Observable<{}>{
    return this.httpClient.delete(`${this.url}/${id}`);
  }

  editUser(id:number,user:Usuario):Observable<Object>{
    return this.httpClient.put(`${this.url1}/${id}`,user)
  }


}
