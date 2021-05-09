package integrated.project.controllers;



import integrated.project.Entitys.Color;


import org.springframework.web.bind.annotation.*;
import integrated.project.repositories.ColorsJpaRepository;
//import integrated.project.models.Products;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ColorsRestController {
    private ColorsJpaRepository colorsJpaRepository;

    public ColorsRestController(ColorsJpaRepository colorsJpaRepository) {
        this.colorsJpaRepository = colorsJpaRepository;
    }

    @GetMapping("/show/colors")
    public List<Color> getColors() {
        return colorsJpaRepository.findAll();
    }


}
