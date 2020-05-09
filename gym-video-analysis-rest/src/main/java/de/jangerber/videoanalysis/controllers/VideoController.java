package de.jangerber.videoanalysis.controllers;

import de.jangerber.videoanalysis.entities.Video;
import de.jangerber.videoanalysis.services.FileStorageService;
import de.jangerber.videoanalysis.services.VideoService;
import de.jangerber.videoanalysis.transfer.VideoCreateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class VideoController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/upload/video",
            method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.MULTIPART_MIXED_VALUE})
    public Video uploadFilePost(@RequestParam("file") MultipartFile file,
                                @RequestPart VideoCreateDTO metadata) {
        log.info("Start upload File");

        UUID uuidFile = fileStorageService.storeFile(file, "video/" + metadata.getGroupId() + "/", "." + metadata.getVideoFormat());

        return videoService.createVideo(metadata, uuidFile);
    }
}
