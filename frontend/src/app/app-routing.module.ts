import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { FinishedComponent } from "./components/finished/finished.component";
import { ReadAllComponent } from "./components/read-all/read-all.component";
import { UpdateComponent } from "./components/update/update.component";

const routes: Routes = [
  {
    path: "",
    component: ReadAllComponent,
  },
  {
    path: "finished",
    component: FinishedComponent,
  },
  {
    path: "update/:id",
    component: UpdateComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
