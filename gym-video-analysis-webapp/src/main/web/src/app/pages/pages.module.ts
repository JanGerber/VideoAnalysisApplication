import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DeviceEditComponent} from './device/device-edit/device-edit.component';

import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatDialogModule} from '@angular/material/dialog';
import {MatRadioModule} from '@angular/material/radio';
import {DevicesComponent} from './device/devices/devices.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {PipeModule} from '../pipes/pipe.module';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';


@NgModule({
  declarations: [
    DeviceEditComponent,
    DevicesComponent,
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    RouterModule,
    MatIconModule,
    MatSelectModule,
    MatDialogModule,
    MatRadioModule,
    MatCheckboxModule,
    PipeModule,
    MatDatepickerModule,
    MatNativeDateModule
  ]
})
export class PagesModule {
}
