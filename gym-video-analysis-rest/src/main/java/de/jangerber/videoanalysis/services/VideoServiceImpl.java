package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.Video;
import de.jangerber.videoanalysis.repositories.VideoRepository;
import de.jangerber.videoanalysis.transfer.VideoCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository repo;

    @Override
    public Video createVideo(VideoCreateDTO metadata, UUID uuidFile) {
        Video video = new Video();
        video.setId(uuidFile);
        video.setGroupId(metadata.getGroupId());
        return repo.save(video);
    }
}
