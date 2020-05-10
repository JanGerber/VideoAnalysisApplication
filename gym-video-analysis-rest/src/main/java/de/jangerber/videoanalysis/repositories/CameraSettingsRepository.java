package de.jangerber.videoanalysis.repositories;

import de.jangerber.videoanalysis.entities.CameraSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CameraSettingsRepository extends JpaRepository<CameraSettings, UUID> {

}
