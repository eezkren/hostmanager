import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeLayoutComponent} from './ui/layouts/home-layout.component';
import {AuthGuard} from './guard/auth.guard';
import {LoginLayoutComponent} from './ui/layouts/login-layout.component';
import {LoginComponent} from './ui/login/login.component';
import {HostListComponent} from './ui/host/host-list.component';

const routes: Routes = [
  {
    path: '',
    component: HomeLayoutComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'host',
        component: HostListComponent,
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    component: LoginLayoutComponent,
    children: [
      {
        path: 'login',
        component: LoginComponent
      }
    ]
  },
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
