package integrated.project.controllers;


import integrated.project.models.Color;
import integrated.project.models.Product_Colors;
import integrated.project.repositories.Product_ColorsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class Product_ColorsController {

    @Autowired
    Product_ColorsJpaRepository Product_ColorsJpaRepository;

    @GetMapping("/productcolors")
    public List<Product_Colors> allProducts(){
        return Product_ColorsJpaRepository.findAll();
    }
}
