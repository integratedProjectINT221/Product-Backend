package integrated.project.repositories;

import integrated.project.Entitys.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsJpaRepository extends JpaRepository<Product,Integer> {
    List<Product> findByBrandBrandId(String brandId);
    Product findByProdId(int prodId);
//    Product findByProdName(String prodName);
//    Product deleteProductByProdId(String prodId);
}
