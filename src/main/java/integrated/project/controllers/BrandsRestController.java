package integrated.project.controllers;

//import integrated.project.models.Color;
import integrated.project.models.Brand;
import integrated.project.repositories.BrandsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8082"})
@RestController
public class BrandsRestController {
    @Autowired
    BrandsJpaRepository BrandsJpaRepository;

    @GetMapping("/brands{id}")
    public Brand show(@PathVariable String id) {

        return BrandsJpaRepository.findById(id).orElse(null);
    }

    @GetMapping("/brands")
    public List<Brand> allProducts(){
        return BrandsJpaRepository.findAll();
    }
}
