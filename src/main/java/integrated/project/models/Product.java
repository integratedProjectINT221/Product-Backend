package integrated.project.models;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "product")

public class Product {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "ProdId")
  private int ProdId;
  private String prodName;
  private String description;
  private double price;
  @Column(name = "brand_BrandId")
  private String brandBrandId;
  private String image;
  @OneToMany(targetEntity = Color.class,mappedBy = "product",cascade = CascadeType.ALL)
 @JsonIgnore
  private Collection<Color> color = new ArrayList<>();

    public int getProdId() {
        return ProdId;
    }

    public void setProdId(int prodId) {
        ProdId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrandBrandId() {
        return brandBrandId;
    }

    public void setBrandBrandId(String brandBrandId) {
        this.brandBrandId = brandBrandId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Color> getProduct_Colors() {
        return color;
    }

    public void setProduct_Colors(Collection<Color> product_Colors) {
        color = product_Colors;
    }
}
