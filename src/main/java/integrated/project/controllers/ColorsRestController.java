package integrated.project.controllers;

import integrated.project.models.Product;
import integrated.project.models.Product_Has_Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import integrated.project.repositories.ColorsJpaRepository;
//import integrated.project.models.Products;
import integrated.project.models.Color;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = {"http://localhost:8082"})
@RestController
public class ColorsRestController {
    @Autowired
    ColorsJpaRepository ColorsJpaRepository;

    @GetMapping("/colors/{id}")
    public Color show(@PathVariable String id) {

        return ColorsJpaRepository.findById(id).orElse(null);
    }

    @GetMapping("/colors")
    public List<Color> allProducts(){
        return ColorsJpaRepository.findAll();
    }

    @PostMapping("/colors")
    public Color addProduct(@RequestBody Color product){
        return ColorsJpaRepository.save(product);
    }
}
