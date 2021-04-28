

package integrated.project.repositories;

//import integrated.project.models.Products;

//import integrated.project.models.Color;
import integrated.project.Entitys.Brand;
import integrated.project.models.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsJpaRepository extends JpaRepository<Brand,String> {
}

