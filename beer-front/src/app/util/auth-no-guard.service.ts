import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthNoGuardService implements CanActivate {

  constructor(private router: Router) { }
  
  public canActivate(): boolean {
    const token = localStorage.getItem('token');
    if(token){
      this.router.navigateByUrl('/list');
      return false;
    }else {
      return true;
    }

  }

}
