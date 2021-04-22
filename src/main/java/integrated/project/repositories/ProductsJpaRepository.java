package integrated.project.repositories;

import integrated.project.models.Product;

import integrated.project.models.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsJpaRepository extends JpaRepository<Product,String> {
}
