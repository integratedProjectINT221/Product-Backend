package integrated.project.repositories;

import integrated.project.models.Product_Has_ColorId;
import integrated.project.models.Product_Has_Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsHasColorsJpaRepository extends JpaRepository<Product_Has_Color, Product_Has_ColorId> {
//    List<Product_Has_Color> findByproduct_ProdIdcolor_ColorId(String companyId);
//List<Product_Has_Color> findByproduct_ProdId(String accountType);
List<Product_Has_Color> findByproductProdIdAndColorColorId(String prodId,String cId);
List<Product_Has_Color> findByproductProdId(String prodId);
}
