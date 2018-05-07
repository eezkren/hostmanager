import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import 'rxjs/add/operator/map'
import {CookieManager} from '../cookie.manager';

@Injectable()
export class AuthService {

  AUTHORIZATION = 'trusted-app:secret';
  AUTH_ENDPOINT = 'http://localhost:8082/oauth/token'
  private loggedIn = new BehaviorSubject<boolean>(this.token.hasToken()); // {1}

  constructor(private router: Router, private http: HttpClient, private token: CookieManager) {
  }

  get isLoggedIn() {
    this.loggedIn.next(this.token.hasToken());
    return this.loggedIn.asObservable(); // {2}
  }

  logout() {                            // {4}
    this.loggedIn.next(false);
    this.token.removeToken();
    this.router.navigate(['/login']);
  }


  attemptAuth(username: string, password: string): Observable<any> {
    const params = new HttpParams()
      .set('username', username)
      .set('password', password)
      .set('grant_type', 'password');

    const headers = new HttpHeaders({
      'Content-type': 'application/x-www-form-urlencoded',
      'Authorization': 'Basic ' + btoa(this.AUTHORIZATION),
      'Accept': 'application/json'
    });

    const options = {
      headers,
      params,
      withCredentials: true
    };
    console.log('attempAuth ::');
    return this.http.post<any>(this.AUTH_ENDPOINT, null, options);
  }

}
