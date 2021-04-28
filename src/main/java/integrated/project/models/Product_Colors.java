package integrated.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import integrated.project.models.Color;
import integrated.project.models.Product;
import integrated.project.models.Product_ColorsId;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_colors")
public class Product_Colors {
  @EmbeddedId
  private Product_ColorsId Product_ColorsId = new Product_ColorsId();

  @ManyToOne
  @MapsId("ProdId")
  @JoinColumn(name = "ProdId")
  @JsonIgnore
  private Product product;

  @ManyToOne
  @MapsId("ColorId")
  @JsonIgnore
  @JoinColumn(name = "ColorId")

  private Color color;

  private long quantity;


    public integrated.project.models.Product_ColorsId getProduct_ColorsId() {
        return Product_ColorsId;
    }

    public void setProduct_ColorsId(integrated.project.models.Product_ColorsId product_ColorsId) {
        Product_ColorsId = product_ColorsId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
