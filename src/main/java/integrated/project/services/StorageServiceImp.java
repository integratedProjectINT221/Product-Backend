package integrated.project.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import integrated.project.repositories.ProductsJpaRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class StorageServiceImp implements StorageService{
    private final Path root;
//    private ProductsJpaRepository productsJpaRepository;


    public StorageServiceImp(StorageProperties properties) {
        this.root = Paths.get(properties.getLocation());

    }


    @Override
//    @PostConstruct
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
//            for (int i = 0; i < productsJpaRepository.findAll().size(); i++) {
//                System.out.println(file.getOriginalFilename());
//                if(file.getOriginalFilename() == productsJpaRepository.findAll().get(i).getImage()){
//                    System.out.println(productsJpaRepository.findAll().get(i).getImage());
//                    if(productsJpaRepository.findByProdName(file.getOriginalFilename()).getImage() == file.getOriginalFilename()){
                    Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
//                }
//            }

        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
//    @PreDestroy
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}

