package de.jangerber.videoanalysis.repositories;

import de.jangerber.videoanalysis.entities.Scene;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SceneRepository extends JpaRepository<Scene, UUID> {

}
