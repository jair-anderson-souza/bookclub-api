import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ErrorService } from './error.service';
import { url } from 'src/app/util/api';

@Injectable()
export class UserService {

  constructor(private httpClient: HttpClient,
    private router: Router,
    private errorService: ErrorService) {

    this.errorService.clear();

  }

  public login(user: any): Observable<any> {
    this.errorService.clear();
    return this.httpClient.post(`${url}users/login`, user, { observe: 'response' })
      .pipe(
        catchError(this.handleError.bind(this))
      );
  }

  public new(user: any): Observable<any> {
    this.errorService.clear();
    return this.httpClient.post(`${url}users/new`, user, { observe: 'response' })
      .pipe(
        catchError(this.handleError.bind(this))
      );
  }

  private handleError(error: HttpErrorResponse, user: any) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      this.errorService.addMessage(error.error);
      return throwError('Something bad happened; please try again later.');
    };
  }
}