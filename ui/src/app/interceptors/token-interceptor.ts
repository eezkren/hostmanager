import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {CookieManager} from '../cookie.manager';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  AUTHORIZATION = 'trusted-app:secret';

  constructor(private cookieManager: CookieManager) {
  }


  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    // getting token
    if (request.url.indexOf('oauth') >= 0) {
      request = request.clone({
        setHeaders: {
          'Content-type': 'application/x-www-form-urlencoded',
          Authorization: 'Basic ' + btoa(this.AUTHORIZATION),
          Accept: 'application/json'
        }
      });
      return next.handle(request);
    }

    // any other request
    request = request.clone({
      setHeaders: {
        Accept: 'application/json',
        Authorization: `Bearer ${this.cookieManager.getToken()}`
      }
    });
    return next.handle(request);
  }
}
