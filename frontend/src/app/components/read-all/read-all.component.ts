import { Component, ElementRef, OnInit, ViewChild } from "@angular/core";
import { Router } from "@angular/router";
import { Todo } from "src/app/models/todo";
import { TodoService } from "src/app/services/todo.service";

@Component({
  selector: "app-read-all",
  templateUrl: "./read-all.component.html",
  styleUrls: ["./read-all.component.css"],
})
export class ReadAllComponent implements OnInit {
  closed = 0;
  todo: Todo = {
    title: "",
    description: "",
    dateToFinishTask: "",
    finished: false,
  };
  list: Todo[] = [];
  finishedList: Todo[] = [];
  description: string = "";
  value: any;

  constructor(private service: TodoService, private router: Router) {}

  ngOnInit(): void {
    this.todo.dateToFinishTask = new Date();
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((answer) => {
      answer.forEach((todo) => {
        if (todo.finished) {
          this.finishedList.push(todo);
        } else {
          this.list.push(todo);
        }
      });
      this.closed = this.finishedList.length;
    });
  }

  finishTask(item: Todo): void {
    item.finished = true;
    this.service.update(item).subscribe(() => {
      this.service.message("Task completed!");
      this.list = this.list.filter((todo) => todo.id !== item.id);
      this.closed++;
    });
  }

  delete(id: any): void {
    this.service.delete(id).subscribe((answer) => {
      if (answer === null) {
        this.service.message("Deleted task successfully!");
        this.list = this.list.filter((todo) => todo.id !== id);
      }
    });
  }

  create() {
    this.formatDate();
    this.service.create(this.todo).subscribe(
      (answer) => {
        this.service.message("New task added successfully");
        setTimeout(() => {
          window.location.reload();
        }, 3000);
      },
      (err) => {
        this.service.message("Failed to create new task");
        this.clear();
      }
    );
  }

  clear() {
    this.todo.description = "";
    this.todo.title = "";
    this.todo.dateToFinishTask.value = "";
  }

  formatDate(): void {
    let date = new Date(this.todo.dateToFinishTask);
    this.todo.dateToFinishTask = `${date.getDate()}/${
      date.getMonth() + 1
    }/${date.getFullYear()}`;
  }

  getFinishDate(): void {
    let date = new Date();
    this.todo.dateToFinishTask = `${date.getDate()}/${
      date.getMonth() + 1
    }/${date.getFullYear()}`;
  }

  navigateToFinishedTasks(): void {
    this.router.navigate(["finished"]);
  }
}
