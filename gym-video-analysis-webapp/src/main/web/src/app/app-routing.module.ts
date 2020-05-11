import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DeviceEditComponent} from './pages/device/device-edit/device-edit.component';
import {LoginComponent} from './login/login.component';
import {AuthGuardService as AuthGuard} from './services/auth-guard.service';
import {DevicesComponent} from './pages/device/devices/devices.component';
import {ImpressumComponent} from './impressum/impressum.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'impressum',
    component: ImpressumComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'device',
    component: DevicesComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'device/:deviceId',
    component: DeviceEditComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'device-create',
    component: DeviceEditComponent,
    canActivate: [AuthGuard]
  },
  {path: '', redirectTo: 'device', pathMatch: 'full'},
  {path: '**', redirectTo: 'device'},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
