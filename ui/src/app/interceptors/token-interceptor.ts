import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {CookieManager} from '../cookie.manager';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  constructor(private cookieManager: CookieManager) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    request = request.clone({
      setHeaders: {
        Accept: 'application/json',
        Authorization: `Bearer ${this.cookieManager.getToken()}`
      }
    });
    return next.handle(request);
  }
}
