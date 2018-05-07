import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styles: []
})
export class SidebarComponent implements OnInit {

  activeAll = false;
  activeNew = false;

  constructor(location: Location, router: Router) {
    this.activeAll = false;
    this.activeNew = false;
    router.events.subscribe((val) => {
      console.log(location.path());
      if (location.path() === '/host') {
        this.activeAll = true;
        this.activeNew = false;
      }
      if (location.path() === '/host/new') {
        this.activeNew = true;
        this.activeAll = false;
      }
    });
  }

  ngOnInit() {
    console.log('init')
  }

  activateAll() {
    if (!this.activeAll) {
      this.activeAll = !this.activeAll;
      this.activeNew = !this.activeNew;
    }
  }

  activateNew() {
    if (!this.activeNew) {
      this.activeNew = !this.activeNew;
      this.activeAll = !this.activeAll;
    }
  }
}
