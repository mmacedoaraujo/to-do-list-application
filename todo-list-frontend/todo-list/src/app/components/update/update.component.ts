import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Todo } from "src/app/models/todo";
import { TodoService } from "src/app/services/todo.service";

@Component({
  selector: "app-update",
  templateUrl: "./update.component.html",
  styleUrls: ["./update.component.css"],
})
export class UpdateComponent implements OnInit {
  todo: Todo = {
    title: "",
    description: "",
    dateToFinishTask: "",
    finished: false,
  };

  constructor(private service: TodoService, private router: Router) {}

  ngOnInit(): void {}

  create() {
    this.formatDate();
    this.service.create(this.todo).subscribe(
      (answer) => {
        this.service.message("New task added successfully");
        this.clear();
      },
      (err) => {
        this.service.message("Failed to create new task");
        this.clear();
      }
    );
    this.navigateToHomePage();
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

  navigateToHomePage(): void {
    this.router.navigate([""]);
  }
}
