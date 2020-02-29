import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatIconRegistry} from '@angular/material/icon';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'cleaningplan-app';
  obsMessage: any;

  constructor(public matIconRegistry: MatIconRegistry,
              public snackBar: MatSnackBar) {
    matIconRegistry.registerFontClassAlias('fa');
    matIconRegistry.registerFontClassAlias('far');
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
  }
}
