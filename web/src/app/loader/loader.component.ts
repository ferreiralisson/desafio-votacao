import { Component } from '@angular/core';
import { Subject } from 'rxjs';
import { HelpersService } from '../services/helpers.service';

@Component({
  selector: 'loader',
  template: '<ngx-loading [show]="(loading | async) || false"></ngx-loading>'
})
export class LoaderComponent {

  public loading: Subject<boolean> = this.loaderService.isLoading;

  constructor(private loaderService: HelpersService) {}

}
