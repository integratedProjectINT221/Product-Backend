package integrated.project.repositories;

import integrated.project.models.ProductHasColorId;
import integrated.project.models.Product_Has_Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsHasColorsJpaRepository extends JpaRepository<Product_Has_Color, String> {
//    List<Product_Has_Color> findByproduct_ProdIdcolor_ColorId(String companyId);
}
