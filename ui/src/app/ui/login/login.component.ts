import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../service/auth.service';
import {CookieManager} from '../../cookie.manager';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: []
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;
  hasError = false;

  constructor(private router: Router, private authService: AuthService, private token: CookieManager) {
  }

  ngOnInit() {
    // reset login status
    // this.authService.logout();
  }


  login(): void {
    this.authService.attemptAuth(this.username, this.password).subscribe(
      data => {
        this.token.saveToken(data.access_token, data.expires_in);
        this.router.navigate(['/host']);
      },
      err => this.hasError = true
    );
  }


}
