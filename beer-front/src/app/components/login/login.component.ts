import { Component, OnInit, OnDestroy } from '@angular/core';
import { ErrorService } from 'src/services/error.service';
import { UserService } from 'src/services/user.service';
import { User } from 'src/app/model/user-model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit, OnDestroy {

  public user = new User();

  constructor(public errorService: ErrorService,
    private userService: UserService,
    private router: Router) {

  }

  ngOnInit() {
  }

  ngOnDestroy() {
  }

  public login() {

    this.userService.login(this.user).subscribe((resp) => {
      let token = resp.headers.get("authorization");
      localStorage.setItem('token', token);
      this.router.navigateByUrl('/list');
    });
  }

  public irParaCadastro() {
    this.router.navigateByUrl('/new');
  }

}
