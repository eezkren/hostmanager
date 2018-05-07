import {Injectable} from '@angular/core';
import {Cookie} from 'ng2-cookies';


const TOKEN_KEY = 'access_token';

@Injectable()
export class CookieManager {

  constructor() {
  }

  public removeToken() {
    Cookie.delete(TOKEN_KEY);
  }

  public saveToken(token: string, expires_in: number) {
    const expires = new Date();
    expires.setSeconds(expires.getSeconds() + expires_in);
    Cookie.set(TOKEN_KEY, token, expires);
  }

  public hasToken(): boolean {
    if (Cookie.get(TOKEN_KEY)) {
      return true;
    }
    return false;
  }

  public getToken(): string {
    return Cookie.get(TOKEN_KEY);
  }
}
