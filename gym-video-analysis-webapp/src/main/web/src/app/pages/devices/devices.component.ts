import {Component, OnInit} from '@angular/core';
import {Device} from '../../models/device';
import {DeviceApiService} from '../../services/device-api.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.scss']
})
export class DevicesComponent implements OnInit {

  devices: Device[] = [];

  loadingState: any = {
    devices: true,
  };

  constructor(private deviceService: DeviceApiService,
              private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.loadDevices();
  }

  deleteDevice(id: string) {
    let deleteSchedule = confirm("Do you want to delete this device?");
    if (deleteSchedule) {
      this.deviceService.deleteDevice(id).subscribe(() => {
        this.loadDevices();
      });
    }
  }


  loadDevices() {
    this.deviceService.getDevices().subscribe(
      data => {
        this.devices = data;
        this.loadingState.devices = false;
      }, error => {
        this.loadingState.devices = false;
      });
  }

}
