import { Component, OnInit } from "@angular/core";
import { Todo } from "src/app/models/todo";

@Component({
  selector: "app-read-all",
  templateUrl: "./read-all.component.html",
  styleUrls: ["./read-all.component.css"],
})
export class ReadAllComponent implements OnInit {
  list: Todo[] = [
    {
      title: "Teste",
      dateToFinishTask: new Date(),
      finished: false,
    },
    {
      title: "Teste2",
      dateToFinishTask: new Date(),
      finished: false,
    }
  ];

  constructor() {}

  ngOnInit(): void {}
}
