import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Todo } from "src/app/models/todo";
import { TodoService } from "src/app/services/todo.service";

@Component({
  selector: "app-finished",
  templateUrl: "finished.component.html",
  styleUrls: ["finished.component.css"],
})
export class FinishedComponent implements OnInit {
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
        }
      });
    });
  }

  home(): void {
    this.router.navigate([''])
  }
}
