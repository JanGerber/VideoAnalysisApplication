package de.jangerber.videoanalysis.controllers;

import de.jangerber.videoanalysis.entities.CameraSettings;
import de.jangerber.videoanalysis.services.CameraSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class CameraSettingsController {

    @Autowired
    private CameraSettingsService settingsService;


    @RequestMapping(value = "/camera_settings", method = RequestMethod.GET)
    public List<CameraSettings> getAllCameraSettingss() {
        return settingsService.getAllCameraSettingsList();
    }


    @RequestMapping(value = "/camera_settings", method = RequestMethod.POST)
    public CameraSettings createCameraSettings(@RequestBody CameraSettings cameraSettings) {
        return settingsService.createCameraSettings(cameraSettings);
    }

    @RequestMapping(value = "/camera_settings/{id}", method = RequestMethod.DELETE)
    public void deleteCameraSettings(@PathVariable UUID id) {
        settingsService.deleteCameraSettings(id);
    }

    @RequestMapping(value = "/camera_settings/{id}", method = RequestMethod.GET)
    public CameraSettings getCameraSettings(@PathVariable UUID id) {
        return settingsService.getCameraSettings(id);
    }

    @RequestMapping(value = "/camera_settings/{id}", method = RequestMethod.PUT)
    public CameraSettings putCameraSettings(@PathVariable UUID id, @RequestBody CameraSettings cameraSettings) {
        return settingsService.updateCameraSettings(cameraSettings);
    }
}
