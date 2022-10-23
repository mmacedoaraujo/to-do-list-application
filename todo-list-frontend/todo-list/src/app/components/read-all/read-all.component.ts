import { Component, OnInit } from "@angular/core";
import { Todo } from "src/app/models/todo";
import { TodoService } from "src/app/services/todo.service";

@Component({
  selector: "app-read-all",
  templateUrl: "./read-all.component.html",
  styleUrls: ["./read-all.component.css"],
})
export class ReadAllComponent implements OnInit {
  closed = 0;

  list: Todo[] = [];

  constructor(private service: TodoService) {}

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((answer) => {
      this.list = answer;
      this.countClosed();
    });
  }

  countClosed(): void {
    for (let todo of this.list) {
      if (todo.finished) {
        this.closed++;
      }
    }
  }
}
