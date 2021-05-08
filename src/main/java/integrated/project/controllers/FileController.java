package integrated.project.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import integrated.project.models.FileInfo;
import integrated.project.repositories.ProductsJpaRepository;
import integrated.project.services.ResponseMessage;
import integrated.project.services.StorageService;
//import integrated.project.services.StorageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;



@RestController
@CrossOrigin(origins = {"http://docker_vuejs:8082"})
public class FileController {

    @Autowired
    StorageService storageService;
//    private ProductsJpaRepository productsJpaRepository;

//    public FileController(ProductsJpaRepository productsJpaRepository) {
//        this.productsJpaRepository = productsJpaRepository;
//    }
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
//            for (int i = 0; i < productsJpaRepository.findAll().size(); i++) {
//                System.out.println(productsJpaRepository.findAll().get(i).getImage());
//                System.out.println(file.getOriginalFilename());
//                if(this.productsJpaRepository.findAll().get(i).getImage() == file.getOriginalFilename()){

                    storageService.save(file);
//                }}


            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        Resource file = storageService.load(filename);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
    }
}
