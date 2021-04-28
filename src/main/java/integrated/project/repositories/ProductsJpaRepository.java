package integrated.project.repositories;

import integrated.project.Entitys.Product;
import integrated.project.models.ProductModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsJpaRepository extends JpaRepository<Product,String> {
    List<Product> findByBrandBrandId(String prodId);
}
