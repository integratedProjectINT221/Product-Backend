package integrated.project.controllers;

//import integrated.project.models.Color;
import integrated.project.models.Product;
import integrated.project.repositories.ProductsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8082"})
@RestController
public class ProductsRestController {
    @Autowired
    ProductsJpaRepository ProductsJpaRepository;

    @GetMapping("/products/{id}")
    public Product show(@PathVariable String id) {

        return ProductsJpaRepository.findById(id).orElse(null);
    }

    @GetMapping("/products")
    public List<Product> allProducts(){
        return ProductsJpaRepository.findAll();
    }

    @PostMapping("/products")
    public  Product addProduct(@RequestBody Product product){
        return ProductsJpaRepository.save(product);
    }
}
