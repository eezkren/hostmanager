import {Component, OnInit} from '@angular/core';
import {HostService} from '../../service/host.service';

@Component({
  selector: 'app-host',
  templateUrl: './host-list.component.html',
  styleUrls: ['./host-list.component.css']
})
export class HostListComponent implements OnInit {

  hosts: any = {};

  constructor(private service: HostService) {
    this.hosts = this.getHosts();
    console.log(this.hosts)
  }

  ngOnInit() {
  }

  getHosts() {
    this.service.getHosts().subscribe(
      data => {
        this.hosts = data;
      },
      err => console.error(err),
      () => console.log('done loading foods')
    );
  }

  onEdit(host) {

  }

  onDelete(host) {

  }
}
