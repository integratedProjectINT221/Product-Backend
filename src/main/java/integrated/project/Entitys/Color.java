package integrated.project.Entitys;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "colors")
//@JsonIdentityInfo(
//
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//
//        property = "colorId")
public class Color {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String colorId;
    private String colorName;

    @ManyToMany(targetEntity = Product.class, mappedBy = "colors", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JsonIgnore

    private List<Product> products;
//    @OneToMany(mappedBy = "color")
//    @JsonIgnore
//    private List<ProductsColors> products = new ArrayList<>();

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

//    public List<ProductsColors> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<ProductsColors> products) {
//        this.products = products;
//    }
}
