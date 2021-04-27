package integrated.project.controllers;

//import integrated.project.models.Color;
import integrated.project.models.Product;
import integrated.project.models.Product_Has_Color;
import integrated.project.repositories.ProductsHasColorsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8082"})
@RestController
public class ProductsHasColorsRestController {
    @Autowired
    ProductsHasColorsJpaRepository ProductsHasColorsJpaRepository;

    @GetMapping("/productsHasColors/{prodId}/{colorId}")
    public List<Product_Has_Color> showByProdIdAndColorId(@PathVariable String prodId,@PathVariable String colorId) {

//        return ProductsHasColorsJpaRepository.findById(id).orElse(null);
//        (Product_Has_Color) ProductsHasColorsJpaRepository.findByproduct_ProdIdcolor_ColorId(id);
        return ProductsHasColorsJpaRepository.findByproductProdIdAndColorColorId(prodId,colorId);
    }

    @GetMapping("/productsHasColors")
    public List<Product_Has_Color> allProducts(){
        return ProductsHasColorsJpaRepository.findAll();
    }


    @GetMapping("/productsHasColors/{prodId}")
    public List<Product_Has_Color> showByProdId(@PathVariable String prodId) {

//        return ProductsHasColorsJpaRepository.findById(id).orElse(null);
//        (Product_Has_Color) ProductsHasColorsJpaRepository.findByproduct_ProdIdcolor_ColorId(id);
        return ProductsHasColorsJpaRepository.findByproductProdId(prodId);
    }

    @PostMapping("/productsHasColors")
    public Product_Has_Color addProduct(@RequestBody Product_Has_Color product){
        return ProductsHasColorsJpaRepository.save(product);
    }

}
