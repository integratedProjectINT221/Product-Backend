package integrated.project.repositories;

//import integrated.project.models.Products;

import integrated.project.Entitys.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import integrated.project.models.ColorModel;


public interface ColorsJpaRepository extends JpaRepository<Color,String> {
}
