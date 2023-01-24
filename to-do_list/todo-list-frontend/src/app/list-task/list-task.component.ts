import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Task } from '../task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-list-task',
  templateUrl: './list-task.component.html',
  styleUrls: ['./list-task.component.css']
})
export class ListTaskComponent {

  task:Task = new Task();
  tasks:Task[];

  constructor(private taskService:TaskService,private router:Router){}

  ngOnInit(): void {
    this.getTasks();
  }

  getTasks() {
    this.taskService.findAllTasks().subscribe(dato => {
      this.tasks = dato;
    })
  }

  deleteTask(id:number){
    this.taskService.deleteTask(id).subscribe( a => {
      this.getTasks();
    })
  }


  saveTask(){
    this.taskService.saveTask(this.task).subscribe( dato => {
      console.log(dato);
      this.getTasks();
    })
  }

  onSumbit(){
    this.saveTask();
    this.getTasks();
  }

  goToTheMain(){
    this.router.navigate(['list-task']);
  }

}
