package de.jangerber.videoanalysis.repositories;

import de.jangerber.videoanalysis.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
