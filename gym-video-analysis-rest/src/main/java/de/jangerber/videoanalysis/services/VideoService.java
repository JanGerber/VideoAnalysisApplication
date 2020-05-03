package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.Video;
import de.jangerber.videoanalysis.transfer.VideoCreateDTO;

import java.util.UUID;

public interface VideoService {
    Video createVideo(VideoCreateDTO metadata, UUID uuidFile);
}
