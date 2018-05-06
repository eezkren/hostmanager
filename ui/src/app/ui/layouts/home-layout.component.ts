import {Component} from '@angular/core';

@Component({
  selector: 'app-home-layout',
  template: `
    <div class="main-container">
      <app-header></app-header>
      <app-topnav></app-topnav>
      <app-main>
      </app-main>
    </div>
  `,
  styles: []
})
export class HomeLayoutComponent {
  title = 'TEST';
}
