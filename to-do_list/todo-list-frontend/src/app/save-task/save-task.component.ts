import { Component, OnInit } from '@angular/core';
import { Task } from '../task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-save-task',
  templateUrl: './save-task.component.html',
  styleUrls: ['./save-task.component.css']
})
export class SaveTaskComponent implements OnInit{

  task:Task= new Task();

  constructor(private taskService:TaskService){}

  ngOnInit(): void {
    console.log(this.task)
  }


  saveUser(){
    this.taskService.saveTask(this.task).subscribe(dato => {
      console.log(dato);
    }
  )}
  onSumbit(){
    this.saveUser();
  }
}
