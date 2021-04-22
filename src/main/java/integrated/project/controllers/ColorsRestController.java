package integrated.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
}
