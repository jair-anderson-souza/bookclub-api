import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable()
export class UserService {

  constructor(private httpClient: HttpClient, 
    private router: Router) { }

  public login(user: any) {
    return this.httpClient.post("http://localhost:8080/users/login", user, { observe: 'response' }).subscribe((resp) => {
      let token = resp.headers.get("authorization");
      localStorage.setItem('token', token);
      this.router.navigateByUrl('/list');
    });
  }
}