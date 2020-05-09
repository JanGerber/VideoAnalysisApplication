package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.Image;
import de.jangerber.videoanalysis.entities.Video;
import de.jangerber.videoanalysis.transfer.ImageCreateDTO;
import de.jangerber.videoanalysis.transfer.VideoCreateDTO;

import java.util.UUID;

public interface ImageService {
    Image createImage(ImageCreateDTO metadata, UUID uuidFile);
}
