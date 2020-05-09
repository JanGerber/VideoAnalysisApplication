package de.jangerber.videoanalysis.repositories;

import de.jangerber.videoanalysis.entities.Image;
import de.jangerber.videoanalysis.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {

}
