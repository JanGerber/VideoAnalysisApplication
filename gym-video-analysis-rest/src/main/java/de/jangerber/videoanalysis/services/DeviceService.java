package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.Device;

import java.util.List;
import java.util.UUID;

public interface DeviceService {
    List<Device> getAllDevices();

    Device updateDevice(Device device);

    Device getDevice(UUID id);

    void deleteDevice(UUID id);

    Device createDevice(Device device);

}
