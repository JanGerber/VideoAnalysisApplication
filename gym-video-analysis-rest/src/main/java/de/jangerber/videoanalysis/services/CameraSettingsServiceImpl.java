package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.CameraSettings;
import de.jangerber.videoanalysis.exception.RecordNotFoundException;
import de.jangerber.videoanalysis.repositories.CameraSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CameraSettingsServiceImpl implements CameraSettingsService {

    @Autowired
    private CameraSettingsRepository repo;


    @Override
    public List<CameraSettings> getAllCameraSettingsList() {
        return repo.findAll();
    }

    @Override
    public CameraSettings updateCameraSettings(CameraSettings device) {
        return repo.save(device);
    }

    @Override
    public CameraSettings getCameraSettings(UUID id) {
        Optional<CameraSettings> optional = repo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RecordNotFoundException("The camera settings with the ID '" + id.toString() + "' could not be found.");
    }

    @Override
    public void deleteCameraSettings(UUID id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RecordNotFoundException("The camera settings with the ID '" + id.toString() + "' could not be found.");
        }
    }

    @Override
    public CameraSettings createCameraSettings(CameraSettings cleaningSchedule) {
        return repo.save(cleaningSchedule);
    }
}
