package de.jangerber.videoanalysis.controllers;

import de.jangerber.videoanalysis.entities.Image;
import de.jangerber.videoanalysis.services.FileStorageService;
import de.jangerber.videoanalysis.services.ImageService;
import de.jangerber.videoanalysis.transfer.ImageCreateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ImageController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/upload/image",
            method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.MULTIPART_MIXED_VALUE})
    public Image uploadFilePost(@RequestParam("file") MultipartFile file,
                                @RequestPart ImageCreateDTO metadata) {
        log.info("Start upload File");

        UUID uuidFile = fileStorageService.storeFile(file,
                "picture/" + metadata.getGroupId() + "/" + metadata.getIdRaspi() + "/", "." + metadata.getImageFormat());

        return imageService.createImage(metadata, uuidFile);
    }

}
