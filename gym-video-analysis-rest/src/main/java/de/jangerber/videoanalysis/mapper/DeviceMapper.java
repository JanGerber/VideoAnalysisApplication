package de.jangerber.videoanalysis.mapper;

import de.jangerber.videoanalysis.entities.Device;
import de.jangerber.videoanalysis.transfer.DeviceDTO;

public interface DeviceMapper {
    DeviceDTO entitiyToDto(Device cleaningSchedule);

    Device dtoToEntitiy(DeviceDTO coachDTO);
}
