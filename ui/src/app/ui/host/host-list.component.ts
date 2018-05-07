import {Component, OnInit} from '@angular/core';
import {HostService} from '../../service/host.service';
import {Host} from '../../model/host';

@Component({
  selector: 'app-host',
  templateUrl: './host-list.component.html',
  styleUrls: ['./host-list.component.css']
})
export class HostListComponent implements OnInit {

  hosts: Host[];
  loading = true;
  total: number;

  constructor(private service: HostService) {
    this.getHosts();
    console.log(this.hosts)
  }

  ngOnInit() {
  }

  getHosts() {
    this.service.getHosts().subscribe(
      data => {
        this.hosts = data as Host[];
        this.total = this.hosts.length;
        this.loading = false;
      },
      err => console.error(err),
      () => console.log('done loading hosts')
    );
  }

  onEdit(host) {

  }

  onDelete(host) {

  }
}
