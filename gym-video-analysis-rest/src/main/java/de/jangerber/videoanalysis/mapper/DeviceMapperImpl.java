package de.jangerber.videoanalysis.mapper;

import de.jangerber.videoanalysis.entities.Device;
import de.jangerber.videoanalysis.transfer.DeviceDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeviceMapperImpl implements DeviceMapper {

    @Override
    public DeviceDTO entitiyToDto(Device device) {
        if (device == null) {
            return null;
        }
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(device.getId().toString());
        deviceDTO.setIpAddress(device.getIpAddress());
        deviceDTO.setName(device.getName());

        return deviceDTO;
    }

    @Override
    public Device dtoToEntitiy(DeviceDTO deviceDTO) {
        if (deviceDTO == null) {
            return null;
        }
        Device device = new Device();
        if (deviceDTO.getId() != null) {
            device.setId(UUID.fromString(deviceDTO.getId()));
        }
        device.setName(deviceDTO.getName());
        device.setIpAddress(deviceDTO.getIpAddress());

        return device;
    }
}
