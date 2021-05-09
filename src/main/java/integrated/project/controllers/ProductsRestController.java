package integrated.project.controllers;

//import integrated.project.models.Color;
//import javax.jcr.ItemNotFoundException
import integrated.project.Entitys.Product;
import integrated.project.repositories.ProductsJpaRepository;
import integrated.project.models.ResponseMessage;
import integrated.project.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

//@CrossOrigin(origins = {"http://localhost:8082"})
@RestController
@RequestMapping("/api")
public class ProductsRestController {
    private ProductsJpaRepository productsJpaRepository;
    @Autowired
    StorageService storageService;

    public ProductsRestController(ProductsJpaRepository productsJpaRepository) {
        this.productsJpaRepository = productsJpaRepository;
    }

    @GetMapping("/show/products")
    public List<Product> getProducts() {
        return productsJpaRepository.findAll();
    }

    @GetMapping("/show/products/brand/{id}")
    public List<Product> getProductsByBrand(@PathVariable String id) {

        return productsJpaRepository.findByBrandBrandId(id);
    }

    @GetMapping("/show/product/{id}")
    public Product getProductsById(@PathVariable int id) {
        return productsJpaRepository.findByProdId(id);
    }

    @DeleteMapping("/delete/product/{id}")
    public ResponseEntity<ResponseMessage> deleteProductsById(@PathVariable int id, HttpServletResponse res) throws URISyntaxException, IOException {
        Product checkExist = productsJpaRepository.findByProdId(id);
        if(checkExist == null){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Not have this product to delete!"));
        }
          productsJpaRepository.deleteById(id);
          storageService.delete(checkExist.getImage());

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Delete product complete"));

    }



    @PostMapping("/create/product")
    public ResponseEntity<ResponseMessage> addProduct(@RequestPart Product product,@RequestParam("file") MultipartFile file) throws IOException {
        Product checkExist = productsJpaRepository.findByProdId(product.getProdId());

        if (checkExist != null) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Already product!"));

        }

        if (!product.getImage().equals(file.getOriginalFilename())){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Cant save because filename and product image name is not the same!"));
        }

        if(this.storageService.save(file)==true){
            product.setImage(product.getImage());
            this.productsJpaRepository.save(product);
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Add product complete"));

    }

    @PutMapping ("/edit/product")
    public ResponseEntity<ResponseMessage> editProduct(@RequestPart Product product,@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        Product checkExist = productsJpaRepository.findByProdId(product.getProdId());
        if(checkExist == null){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Not have this product!"));
//            throw new RuntimeException("Fail na");
        }

//        ItemNotFoundException

        if(file != null){
            if (!product.getImage().equals(file.getOriginalFilename())){
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Cant save because filename and product image name is not the same!"));
            }

            this.storageService.delete(checkExist.getImage());
            this.storageService.save(file);
        }

        this.productsJpaRepository.save(product);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Edit product complete"));

    }




}

