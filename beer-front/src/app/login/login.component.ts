import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from 'src/services/user.service';
import { ErrorService } from 'src/services/error.service';

export class User {

  username: string;
  password: string;
  
  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit, OnDestroy {

  public user = new User();

  constructor(private httpClient: HttpClient, 
    public errorService: ErrorService,
    private userService: UserService) {
  }

  ngOnInit() {
    this.errorService.clear();
  }

  ngOnDestroy() {
    this.errorService.clear();
  }

  login() {

    this.userService.login(this.user);
  }

}
