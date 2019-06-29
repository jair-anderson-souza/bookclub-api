import { Component, OnInit, OnDestroy } from '@angular/core';
import { User } from '../model/user-model';
import { UserService } from 'src/services/user.service';
import { Router } from '@angular/router';
import { ErrorService } from 'src/services/error.service';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.scss']
})
export class NewComponent implements OnInit, OnDestroy {

  public user = new User();
  public role: string;

  constructor(private userService: UserService,
    private router: Router,
    public errorService: ErrorService) { }

  ngOnInit() {
    this.errorService.clear();
  }

  ngOnDestroy() {
    this.errorService.clear();
  }

  newUser() {
    this.user.roles.push(this.role);
    this.userService.new(this.user).subscribe((resp) => {
      this.errorService.addMessage("Usuário cadastrado com sucesso!!");
      this.router.navigateByUrl('/new');
    })
  }

  public irParaLogin(){
    this.router.navigateByUrl("/login");
  }

}
