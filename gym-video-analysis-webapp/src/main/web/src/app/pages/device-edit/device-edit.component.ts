import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DeviceApiService} from '../../services/device-api.service';
import {Device} from '../../models/device';

@Component({
  selector: 'app-device-edit',
  templateUrl: './device-edit.component.html',
  styleUrls: ['./device-edit.component.scss']
})
export class DeviceEditComponent implements OnInit {

  device: Device = new Device();
  loadingStates: any = {
    cleaningSchedule: false,
    groups: false
  };

  constructor(private route: ActivatedRoute,
              private router: Router,
              private scheduleService: DeviceApiService) {
  }

  ngOnInit(): void {
    const deviceId = this.route.snapshot.paramMap.get('deviceId');
    if (deviceId) {
      this.loadDevice(deviceId);
    }
  }

  loadDevice(deviceId: string) {
    this.loadingStates.cleaningSchedule = true;
    this.scheduleService.getDevice(deviceId).subscribe(
      data => {
        this.device = data;
        this.loadingStates.cleaningSchedule = false;
      }, error => {
        this.loadingStates.cleaningSchedule = false;
      })
  }

  saveDevice() {
    if (this.device.id) {
      this.scheduleService.updateCleaningSchedule(this.device).subscribe(
        data => {
          this.device = data;
          this.navigateBack();
        });
    } else {
      this.scheduleService.createDevice(this.device).subscribe(
        data => {
          this.device = data;
          this.navigateBack();
        });
    }
  }


  private navigateBack() {
    this.router.navigate(['/devices']);
  }
}
