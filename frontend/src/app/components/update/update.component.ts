import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
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

  constructor(
    private service: TodoService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.todo.id = this.route.snapshot.paramMap.get("id")!;
    this.findById();
  }

  findById(): void {
    this.service.findById(this.todo.id).subscribe((answer) => {
      this.todo = answer;
    });
  }

  update(): void {
    this.service.update(this.todo).subscribe(
      (answer) => {
        this.service.message("Task updated successfully!");
        this.router.navigate([""]);
      },
      (err) => {
        this.service.message("Failed to update task");
        this.router.navigate([""]);
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

  navigateToHomePage(): void {
    this.router.navigate([""]);
  }
}
