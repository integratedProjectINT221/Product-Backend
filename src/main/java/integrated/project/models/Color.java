package integrated.project.models;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "color")

public class Color {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int ColorId;
  private String colorName;
  @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
  @JsonIgnore
  private Collection<Product> product = new ArrayList<>();

  public int getColorId() {
    return ColorId;
  }

  public void setColorId(int colorId) {
    ColorId = colorId;
  }

  public String getColorName() {
    return colorName;
  }

  public void setColorName(String colorName) {
    this.colorName = colorName;
  }

  public Collection<integrated.project.models.Product> getProduct_Colors() {
    return product;
  }

  public void setProduct_Colors(Collection<integrated.project.models.Product> product_Colors) {
    product = product_Colors;
  }
}
