import { Injectable } from '@angular/core';
import { map, catchError } from 'rxjs/operators';
import { Router } from '@angular/router';
import { ErrorService } from 'src/services/error.service';
import { HttpRequest, HttpHandler, HttpInterceptor, HttpProgressEvent, HttpHeaderResponse, HttpSentEvent, HttpResponse, HttpUserEvent, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private router: Router, private errorService: ErrorService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpSentEvent | HttpHeaderResponse | HttpProgressEvent | HttpResponse<any> | HttpUserEvent<any>> {

    this.errorService.clear();

    let authReq = req;
    let token = localStorage.getItem('token');
    // if (token != null) {
    //   authReq = req.clone({ headers: req.headers.set('Authorization', token) });
    // }

    return next.handle(authReq);
    }

  //   return next.handle(authReq).pipe(
  //     catchError((error: HttpErrorResponse) => {
  //       let data = {};
  //       data = {
  //         reason: error && error.error ? error.error : '',
  //         status: error.status
  //       };
  //       this.errorService.addMessage(error.error);
  //       return Observable.throw(data);
  //     }));
  // }

}