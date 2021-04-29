package integrated.project.controllers;

//import integrated.project.models.Color;
import integrated.project.Entitys.Product;
import integrated.project.models.ProductModel;
import integrated.project.repositories.ProductsJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return productsJpaRepository.findByBrandBrandId(id);
    }

    @GetMapping("/productsById/{id}")
    public List<Product> getProductsById(@PathVariable String id) {
        return productsJpaRepository.findByProdId(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return this.productsJpaRepository.save(product);
    }


}

