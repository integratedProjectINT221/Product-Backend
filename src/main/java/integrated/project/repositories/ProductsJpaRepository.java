package integrated.project.repositories;

import integrated.project.Entitys.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsJpaRepository extends JpaRepository<Product,String> {
    List<Product> findByBrandBrandId(String brandId);
    Product findByProdId(String prodId);
//    Product deleteProductByProdId(String prodId);
}
