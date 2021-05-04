package integrated.project.services;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    public void init();

    public boolean save(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll();

    public void delete(String oldImage) throws IOException;

    public boolean replace(MultipartFile file,String oldImage);

    public Stream<Path> loadAll();
}
