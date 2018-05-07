import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CookieManager} from '../cookie.manager';
import {Host} from '../model/host';

@Injectable()
export class HostService {

  private BASE_URL = 'http://localhost:8082/';

  constructor(private http: HttpClient, private cookieManager: CookieManager) {
  }

  getHosts() {
    return this.http.get(this.BASE_URL + 'hosts');
  }

  createHost(newHost: Host) {
    return this.http.post(this.BASE_URL + 'hosts', newHost);
  }

  updateHost(newHost: Host) {
    return this.http.put(this.BASE_URL + 'hosts/' + newHost.id, newHost);
  }

  findById(id: number) {
    return this.http.get(this.BASE_URL + 'hosts/' + id);
  }

}
