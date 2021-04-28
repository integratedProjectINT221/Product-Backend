package integrated.project.repositories;

import integrated.project.Entitys.Product;
import integrated.project.models.ProductModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsJpaRepository extends JpaRepository<Product,String> {
}
