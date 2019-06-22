import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { BeerService } from 'src/services/beer.service';
import { ListBeerComponent } from './list-beer/list-beer.component';
import { DateService } from 'src/services/date.service';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { TokenInterceptor } from './util/token-interceptor';
import { AuthGuardService } from './auth-guard.service';
import { UserService } from 'src/services/user.service';
import { ErrorService } from 'src/services/error.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListBeerComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BeerService, DateService, UserService, AuthGuardService, ErrorService, {
    provide: HTTP_INTERCEPTORS,
    multi: true,
    useClass: TokenInterceptor
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
