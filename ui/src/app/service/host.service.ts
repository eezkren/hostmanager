import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CookieManager} from '../cookie.manager';

@Injectable()
export class HostService {

  private BASE_URL = 'http://localhost:8082/';

  constructor(private http: HttpClient, private cookieManager: CookieManager) {
  }

  getHosts() {
    return this.http.get(this.BASE_URL + 'hosts');
  }

}
