package de.jangerber.videoanalysis.mapper;

import de.jangerber.videoanalysis.entities.Device;
import de.jangerber.videoanalysis.services.CameraSettingsService;
import de.jangerber.videoanalysis.services.IntrinsicParameterService;
import de.jangerber.videoanalysis.transfer.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeviceMapperImpl implements DeviceMapper {

    @Autowired
    private CameraSettingsService cameraSettingsService;

    @Autowired
    private IntrinsicParameterService intrinsicParameterService;

    @Override
    public DeviceDTO entityToDto(Device device) {
        if (device == null) {
            return null;
        }
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(device.getId().toString());
        deviceDTO.setIpAddress(device.getIpAddress());
        deviceDTO.setName(device.getName());
        if (device.getCameraSettings() != null) {
            deviceDTO.setCameraSettings(device.getCameraSettings().getId().toString());
        }
        if (device.getIntrinsicParameters() != null) {
            deviceDTO.setIntrinsicParameters(device.getIntrinsicParameters().getId().toString());
        }

        return deviceDTO;
    }

    @Override
    public Device dtoToEntity(DeviceDTO deviceDTO) {
        if (deviceDTO == null) {
            return null;
        }
        Device device = new Device();
        if (deviceDTO.getId() != null) {
            device.setId(UUID.fromString(deviceDTO.getId()));
        }
        device.setName(deviceDTO.getName());
        device.setIpAddress(deviceDTO.getIpAddress());

        if (deviceDTO.getCameraSettings() != null) {
            UUID cameraSettingsUUID = UUID.fromString(deviceDTO.getCameraSettings());
            device.setCameraSettings(cameraSettingsService.getCameraSettings(cameraSettingsUUID));
        }
        if (deviceDTO.getIntrinsicParameters() != null) {
            UUID intrinsicUUID = UUID.fromString(deviceDTO.getIntrinsicParameters());
            device.setIntrinsicParameters(intrinsicParameterService.getIntrinsicParameter(intrinsicUUID));
        }

        return device;
    }
}
