package integrated.project.repositories;

//import integrated.project.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import integrated.project.models.Color;

public interface ColorsJpaRepository extends JpaRepository<Color,String> {
}
