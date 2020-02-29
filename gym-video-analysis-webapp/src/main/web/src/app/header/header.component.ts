import {AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {Observable} from 'rxjs';
import {map, shareReplay} from 'rxjs/operators';
import {MenueItem} from '../models/menue-item';
import {AuthService} from '../services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit, OnDestroy, AfterViewInit {

  loginObservable: any;

  menueItems: MenueItem[] = [{
    link: '/device',
    name: 'Devices',
    icon: 'videocam'
  }, {
    link: '/scene',
    name: 'Scenes',
    icon: 'landscape'
  }, {
    link: '/video',
    name: 'Videos',
    icon: 'ondemand_video'
  }
  ];

  smallIcon: boolean = false;
  resize: boolean = true;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  isTablet$: Observable<boolean> = this.breakpointObserver.observe([Breakpoints.Tablet, Breakpoints.Medium])
    .pipe(
      map(result => result.matches),
      shareReplay()
    );


  constructor(private breakpointObserver: BreakpointObserver,
              private authService: AuthService) {
  }

  ngOnInit(): void {
    if (this.authService.isLoggedIn()) {
      this.addMenueItemsAdmin();
    }


  }

  ngAfterViewInit(): void {
    this.loginObservable = this.authService.newLogin.subscribe(data => {
      if (this.menueItems.length <= 3) {
        this.addMenueItemsAdmin();
      }
    });
  }

  ngOnDestroy(): void {
    this.loginObservable.unsubscribe();
  }


  logout() {
    this.authService.logout();
    if (this.menueItems.length >= 3) {
      this.menueItems = this.menueItems.slice(0, 3);
    }
  }

  toggleSmall() {
    this.resize = true;
    this.smallIcon = !this.smallIcon;
    setTimeout(() => {
      this.resize = false;
    });
  }

  private addMenueItemsAdmin() {
    this.menueItems.push();
  }
}
