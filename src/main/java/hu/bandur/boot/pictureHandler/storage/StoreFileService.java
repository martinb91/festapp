package hu.bandur.boot.pictureHandler.storage;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface StoreFileService {

    final static Path rootLocation = Paths.get("upload-dir");

    void storeFile(MultipartFile file, int id);
}
