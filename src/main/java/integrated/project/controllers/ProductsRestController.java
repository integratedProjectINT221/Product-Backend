package integrated.project.controllers;

//import integrated.project.models.Color;
//import javax.jcr.ItemNotFoundException
import integrated.project.Entitys.Product;
import integrated.project.repositories.ProductsJpaRepository;
import integrated.project.services.ResponseMessage;
import integrated.project.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = {"http://localhost:8082"})
@RestController
public class ProductsRestController {
    private ProductsJpaRepository productsJpaRepository;
    @Autowired
    StorageService storageService;

    public ProductsRestController(ProductsJpaRepository productsJpaRepository) {
        this.productsJpaRepository = productsJpaRepository;
    }
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productsJpaRepository.findAll();
    }

    @GetMapping("/productsByBrand/{id}")
    public List<Product> getProductsByBrand(@PathVariable String id) {
//        for (int i = 0; i < productsJpaRepository.findAll().size(); i++) {
//        System.out.println(productsJpaRepository.findAll().get(i).getImage());}
        return productsJpaRepository.findByBrandBrandId(id);
    }

    @GetMapping("/products/{id}")
    public Product getProductsById(@PathVariable int id) {
        return productsJpaRepository.findByProdId(id);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ResponseMessage> deleteProductsById(@PathVariable int id, HttpServletResponse res) throws URISyntaxException, IOException {
        Product checkExist = productsJpaRepository.findByProdId(id);
        if(checkExist == null){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Not have this product to delete!"));
//            throw new RuntimeException("Fail na");
        }
          productsJpaRepository.deleteById(id);
          storageService.delete(checkExist.getImage());

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Delete product complete"));
//        URI yahoo = new URI("http://www.yahoo.com");
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(yahoo);
//        return "forward:/asds";
//        res.sendRedirect("/redirect");
//        return null;
//        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

//    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
//    public void method(HttpServletResponse httpServletResponse) throws IOException {
////        httpServletResponse.setHeader("Location", "www.google.com");
////        httpServletResponse.setStatus(302);
//        httpServletResponse.sendRedirect("www.google.com");
//    }
//@RequestMapping("/redirect")
//public ResponseEntity<Object> redirectToExternalUrl() throws URISyntaxException {
//    URI yahoo = new URI("http://www.yahoo.com");
//    HttpHeaders httpHeaders = new HttpHeaders();
//    httpHeaders.setLocation(yahoo);
//    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
//}

    @PostMapping("/products2")
    public ResponseEntity<ResponseMessage> addProduct(@RequestBody Product product){
        Product checkExist = productsJpaRepository.findByProdId(product.getProdId());
//        System.out.println(this.productsJpaRepository.save(product).getProdId());
//        System.out.println(checkExist.getProdId());
        if(checkExist != null){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Already product!"));
//            throw new RuntimeException("Fail na");
        }
        product.setImage(product.getImage().toUpperCase(Locale.ROOT));
        this.productsJpaRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Add product complete"));

    }

    @PostMapping("/products")
    public ResponseEntity<ResponseMessage> addProduct2(@RequestPart Product product,@RequestParam("file") MultipartFile file) throws IOException {
        Product checkExist = productsJpaRepository.findByProdId(product.getProdId());
//        Product checkExist = productsJpaRepository.findByProdId(product.getProdId());
        if (checkExist != null) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Already product!"));
//            throw new RuntimeException("Fail na");
        }
//        System.out.println(this.productsJpaRepository.save(product));
//        if(this.storageService.save(file)==true){
////            this.storageService.save(file);
//            System.out.println(this.productsJpaRepository.save(product));
//            this.productsJpaRepository.save(product);
//
//            System.out.println(productsJpaRepository.findByProdId(product.getProdId()));
//            if(productsJpaRepository.findByProdId(product.getProdId())==null){
//                this.storageService.delete(file);
//            }
//        }
//        this.productsJpaRepository.save(product);
//        this.storageService.save(file);
//        if (productsJpaRepository.findByProdId(product.getProdId()) == null) {
//            this.storageService.delete(file);
//        }
        if(this.storageService.save(file)==true){
            product.setImage(product.getImage().toUpperCase(Locale.ROOT));
            this.productsJpaRepository.save(product);
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Add product complete"));

    }

    @PutMapping ("/products")
    public ResponseEntity<ResponseMessage> editProduct(@RequestPart Product product,@RequestParam("file") MultipartFile file){
        Product checkExist = productsJpaRepository.findByProdId(product.getProdId());
        if(checkExist == null){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Not have this product!"));
//            throw new RuntimeException("Fail na");
        }
//        ItemNotFoundException
        System.out.println(checkExist.getImage());
        this.storageService.replace(file,checkExist.getImage());
        product.setImage(product.getImage().toUpperCase(Locale.ROOT));
        this.productsJpaRepository.save(product);
//        this.productsJpaRepository.save(product).getImage().toUpperCase(Locale.ROOT);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Edit product complete"));

    }


}

