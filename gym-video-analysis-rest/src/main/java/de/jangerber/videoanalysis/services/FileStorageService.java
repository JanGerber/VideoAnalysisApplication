package de.jangerber.videoanalysis.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface FileStorageService {
    UUID storeFile(MultipartFile file, String folder, String fileExtension);
}
