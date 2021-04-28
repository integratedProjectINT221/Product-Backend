package integrated.project.controllers;

import integrated.project.Entitys.Brand;
import integrated.project.models.BrandModel;
import integrated.project.repositories.BrandsJpaRepository;
import integrated.project.repositories.ColorsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8082"})
@RestController
public class BrandsRestController {

    private BrandsJpaRepository brandsJpaRepository;
    public BrandsRestController(BrandsJpaRepository brandsJpaRepository) {
        this.brandsJpaRepository = brandsJpaRepository;
    }

    @GetMapping("/brands")
    public List<Brand> getBrands(){
        return this.brandsJpaRepository.findAll();
    }
}
