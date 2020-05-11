package de.jangerber.videoanalysis.mapper;

import de.jangerber.videoanalysis.entities.Device;
import de.jangerber.videoanalysis.transfer.DeviceDTO;

public interface DeviceMapper {
    DeviceDTO entityToDto(Device cleaningSchedule);

    Device dtoToEntity(DeviceDTO coachDTO);
}
