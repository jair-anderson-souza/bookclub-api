import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AuthNoGuardService } from './util/auth-no-guard.service';
import { AuthGuardService } from './util/auth-guard.service';
import { ListBeerComponent } from './components/list-beer/list-beer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { NewComponent } from './new/new.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent, canActivate: [AuthNoGuardService] },
  { path: 'list', component: ListBeerComponent, canActivate: [AuthGuardService] },
  { path: 'new', component: NewComponent, canActivate: [AuthNoGuardService] },  
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
