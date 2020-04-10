import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListAccountComponent } from "./list-account/list-account.component";
import { CreateAccountComponent } from "./create-account/create-account.component";
import { UpdateAccountComponent } from "./update-account/update-account.component";
import { DetailsAccountComponent } from "./details-account/details-account.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'account',
    pathMatch: 'full'
  },
  {
    path: 'accounts',
    component: ListAccountComponent
  },
  {
    path: 'add',
    component: CreateAccountComponent,
  },
  {
    path: 'update/:id',
    component: UpdateAccountComponent,
  },
  {
    path: 'details/:id',
    component: DetailsAccountComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
