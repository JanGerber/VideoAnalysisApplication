package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.Device;
import de.jangerber.videoanalysis.exception.RecordNotFoundException;
import de.jangerber.videoanalysis.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepo;


    @Override
    public List<Device> getAllDevices() {
        return deviceRepo.findAll();
    }

    @Override
    public Device updateDevice(Device device) {
        return deviceRepo.save(device);
    }

    @Override
    public Device getDevice(UUID id) {
        Optional<Device> optional = deviceRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RecordNotFoundException("The device with the ID '" + id.toString() + "' could not be found.");
    }

    @Override
    public void deleteDevice(UUID id) {
        if (deviceRepo.existsById(id)) {
            deviceRepo.deleteById(id);
        } else {
            throw new RecordNotFoundException("The device with the ID '" + id.toString() + "' could not be found.");
        }
    }

    @Override
    public Device createDevice(Device cleaningSchedule) {
        return deviceRepo.save(cleaningSchedule);
    }
}
