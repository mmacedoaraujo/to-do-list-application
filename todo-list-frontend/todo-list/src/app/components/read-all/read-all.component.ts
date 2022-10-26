import { Component, OnInit } from "@angular/core";
import { Router, TitleStrategy } from "@angular/router";
import { Observable } from "rxjs";
import { Todo } from "src/app/models/todo";
import { TodoService } from "src/app/services/todo.service";
import { FinishedComponent } from "../finished/finished.component";

@Component({
  selector: "app-read-all",
  templateUrl: "./read-all.component.html",
  styleUrls: ["./read-all.component.css"],
})
export class ReadAllComponent implements OnInit {
  closed = 0;

  list: Todo[] = [];
  finishedList: Todo[] = [];

  constructor(private service: TodoService, private router: Router) {}

  ngOnInit(): void {
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
    item.finished = true
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

  navigateToFinishedTasks(): void {
    this.router.navigate(["finished"]);
  }
}
