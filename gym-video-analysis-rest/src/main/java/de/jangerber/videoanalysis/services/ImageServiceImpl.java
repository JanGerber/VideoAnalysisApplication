package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.Image;
import de.jangerber.videoanalysis.entities.Video;
import de.jangerber.videoanalysis.repositories.ImageRepository;
import de.jangerber.videoanalysis.repositories.VideoRepository;
import de.jangerber.videoanalysis.transfer.ImageCreateDTO;
import de.jangerber.videoanalysis.transfer.VideoCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository repo;

    @Override
    public Image createImage(ImageCreateDTO metadata, UUID uuidFile) {
        Image image = new Image();
        image.setId(uuidFile);
        image.setGroupId(metadata.getGroupId());
        image.setIdRaspi(metadata.getIdRaspi());
        return repo.save(image);
    }
}
