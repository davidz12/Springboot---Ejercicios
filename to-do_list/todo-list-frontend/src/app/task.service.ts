import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from './task';

@Injectable({
  providedIn: 'root'
})

export class TaskService {

  constructor(private httpClient : HttpClient) { }

  private urlBase = "http://localhost:8080/api/tasks";
  


  saveTask(task:Task):Observable<Object> {
    return this.httpClient.post(`${this.urlBase}/${"task"}`, task);
  }

  deleteTask(id:number):Observable<{}>{
    return this.httpClient.delete(`${this.urlBase}/${"delete"}/${id}`);
  }

  findTask(id:number):Observable<Task> {
    return this.httpClient.get<Task>(`${this.urlBase}/${id}`);
  }

  findAllTasks():Observable<Task[]> {
    return this.httpClient.get<Task[]>(`${this.urlBase}/${"list"}`);
  }


}
