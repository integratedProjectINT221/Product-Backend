package integrated.project.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
//@JsonIgnoreProperties(value = "products")
@Entity
@Table(name="Brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"brandId","brandName"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Brand{
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private String brandId;
    private String brandName;
    @OneToMany(mappedBy="brand",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products;
//    public String getBrandId() {
//        return brandId;
//    }
//
//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
//
//    public void setBrandId(String brandId) {
//        this.brandId = brandId;
//    }
//
//    public String getBrandName() {
//        return brandName;
//    }
//
//    public void setBrandName(String brandName) {
//        this.brandName = brandName;
//    }
}
