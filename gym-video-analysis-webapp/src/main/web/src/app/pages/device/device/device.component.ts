import {Component, OnInit} from '@angular/core';
import {Device} from '../../../models/device';
import {ActivatedRoute, Router} from '@angular/router';
import {DeviceApiService} from '../../../services/device-api.service';
import {ThemePalette} from '@angular/material/core';


@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: ['./device.component.scss']
})
export class DeviceComponent implements OnInit {

  device: Device = new Device();
  color: ThemePalette = 'accent'
  loadingStates: any = {
    device: true,
    videoStream: false,
    settings: false
  };

  constructor(private route: ActivatedRoute,
              private router: Router,
              private scheduleService: DeviceApiService) {
  }

  ngOnInit(): void {
    const deviceId = this.route.snapshot.paramMap.get('deviceId');
    this.loadDevice(deviceId);
  }

  loadDevice(deviceId: string) {
    this.loadingStates.cleaningSchedule = true;
    this.scheduleService.getDevice(deviceId).subscribe(
      data => {
        this.device = data;
        this.loadingStates.device = false;
      }, error => {
        this.loadingStates.device = false;
      })
  }

  editDevice() {
    this.router.navigate([`/device/${this.device.id}/edit`]);
  }
}
