package de.jangerber.videoanalysis.repositories;

import de.jangerber.videoanalysis.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {

}
