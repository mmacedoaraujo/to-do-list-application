import { ViewportScroller } from "@angular/common";
import { ChangeDetectionStrategy, Component, EventEmitter, OnInit, Output } from "@angular/core";
import { Router, RouterModule } from "@angular/router";

@Component({
  selector: "app-footer",
  templateUrl: "./footer.component.html",
  styleUrls: ["./footer.component.css"]
})
export class FooterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
}
