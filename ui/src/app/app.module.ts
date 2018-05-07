import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {ClarityModule} from '@clr/angular';
import {HeaderComponent} from './ui/header/header.component';
import {MainComponent} from './ui/main/main.component';
import {LoginComponent} from './ui/login/login.component';
import {SidebarComponent} from './ui/nav/sidebar/sidebar.component';
import {TopnavComponent} from './ui/nav/topnav/topnav.component';
import {AuthGuard} from './guard/auth.guard';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthService} from './service/auth.service';
import {AppRoutingModule} from './app-routing.module';
import {HomeLayoutComponent} from './ui/layouts/home-layout.component';
import {LoginLayoutComponent} from './ui/layouts/login-layout.component';
import {HostListComponent} from './ui/host/host-list.component';
import {CookieManager} from './cookie.manager';
import {HostService} from './service/host.service';
import {TokenInterceptor} from './interceptors/token-interceptor';
import {HostComponent} from './ui/host/host.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent,
    TopnavComponent,
    MainComponent,
    HostListComponent,
    LoginComponent,
    HomeLayoutComponent,
    LoginLayoutComponent,
    HostComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ClarityModule,
    AppRoutingModule,
    // other imports here)
  ],
  providers: [AuthService, AuthGuard, CookieManager, HostService, {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
