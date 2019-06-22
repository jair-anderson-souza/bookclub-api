import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { ListBeerComponent } from './components/list-beer/list-beer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BeerService } from 'src/services/beer.service';
import { UserService } from 'src/services/user.service';
import { AuthGuardService } from './util/auth-guard.service';
import { AuthNoGuardService } from './util/auth-no-guard.service';
import { ErrorService } from 'src/services/error.service';
import { NewComponent } from './new/new.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListBeerComponent,
    NewComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BeerService, UserService, AuthGuardService, AuthNoGuardService, ErrorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
