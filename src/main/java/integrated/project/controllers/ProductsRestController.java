package integrated.project.controllers;

//import integrated.project.models.Color;
import integrated.project.Entitys.Product;
import integrated.project.repositories.ProductsJpaRepository;
import integrated.project.services.ResponseMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8082"})
@RestController
public class ProductsRestController {
    private ProductsJpaRepository productsJpaRepository;

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

    @PostMapping("/products")
    public ResponseEntity<ResponseMessage> addProduct(@RequestBody Product product){
        Product checkExist = productsJpaRepository.findByProdId(product.getProdId());
        if(checkExist != null){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Already product!"));
//            throw new RuntimeException("Fail na");
        }
        this.productsJpaRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Add product complete"));

    }

    @PutMapping ("/products")
    public ResponseEntity<ResponseMessage> editProduct(@RequestBody Product product){
        Product checkExist = productsJpaRepository.findByProdId(product.getProdId());
        if(checkExist == null){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Not have this product!"));
//            throw new RuntimeException("Fail na");
        }
        this.productsJpaRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Edit product complete"));

    }


}

