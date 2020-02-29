import {TestBed} from '@angular/core/testing';

import {DeviceApiService} from './device-api.service';

describe('CleaningScheduleApiService', () => {
  let service: DeviceApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeviceApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
