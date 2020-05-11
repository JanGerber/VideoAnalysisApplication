package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.CameraSettings;

import java.util.List;
import java.util.UUID;

public interface CameraSettingsService {
    List<CameraSettings> getAllCameraSettingsList();

    CameraSettings updateCameraSettings(CameraSettings device);

    CameraSettings getCameraSettings(UUID id);

    void deleteCameraSettings(UUID id);

    CameraSettings createCameraSettings(CameraSettings device);

}
