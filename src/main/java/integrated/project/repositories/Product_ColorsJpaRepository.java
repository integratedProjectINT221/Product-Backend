package integrated.project.repositories;


import integrated.project.models.Product_Colors;
import integrated.project.models.Product_ColorsId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product_ColorsJpaRepository extends JpaRepository<Product_Colors, Product_ColorsId> {
//    List<Product_Colors> findByProdIdColorId(int departmentId);
}
