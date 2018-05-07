import {Component, OnInit, ViewChild} from '@angular/core';
import {Host} from '../../model/host';
import {HostService} from '../../service/host.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-host',
  templateUrl: './host.component.html',
  styleUrls: ['./host.component.css']
})
export class HostComponent implements OnInit {

  host = <Host>{};
  submitted = false;
  hostCreated = false;

  @ViewChild('hostForm')
  public hostForm: NgForm;

  constructor(private service: HostService,
              private route: ActivatedRoute,
              private router: Router) {

    this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.service.findById(id).subscribe((host: Host) => {
          if (host) {
            this.host = host;
          } else {
            console.log(`Car with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  gotoList() {
    this.router.navigate(['/hosts']);
  }

  reSave(): void {
    this.submitted = false;
    this.hostCreated = false;
    if (!this.host.id) {
      this.hostForm.reset();
      this.host = <Host>{};
    }
  }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted = true;
    this.saveHost(this.host);
  }

  saveHost(newHost: Host) {
    if (newHost.id) {
      this.service.updateHost(newHost).subscribe(
        data => {
          this.hostCreated = true;
        },
        err => console.error(err),
        () => console.log('host updated')
      );
    } else {
      this.service.createHost(newHost).subscribe(
        data => {
          this.hostCreated = true;
        },
        err => console.error(err),
        () => console.log('host created')
      );
    }
  }
}
