import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListBeerComponent } from './list-beer/list-beer.component';

const routes: Routes = [
  { path: '', component: ListBeerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
