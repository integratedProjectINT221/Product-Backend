package integrated.project.controllers;



import integrated.project.Entitys.Color;


import org.springframework.web.bind.annotation.*;
import integrated.project.repositories.ColorsJpaRepository;
//import integrated.project.models.Products;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:8082"})
@CrossOrigin(origins = {"http://docker_vuejs:8082"})
@RestController
public class ColorsRestController {
    private ColorsJpaRepository colorsJpaRepository;

    public ColorsRestController(ColorsJpaRepository colorsJpaRepository) {
        this.colorsJpaRepository = colorsJpaRepository;
    }

    @GetMapping("/colors")
    public List<Color> getColors() {
        return colorsJpaRepository.findAll();
    }

//    @PostMapping("/colors")
//    public Color addColor(@RequestBody Color color){
//        return this.colorsJpaRepository.save(color);
//    }
}
