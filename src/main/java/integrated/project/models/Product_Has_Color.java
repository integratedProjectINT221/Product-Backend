package integrated.project.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ProductHasColorId.class)
public class Product_Has_Color {
  @Id
  private String product_ProdId;
  @Id
  private String color_ColorId;
  private long quantity;


  public String getProductProdId() {
    return product_ProdId;
  }

  public void setProductProdId(String productProdId) {
    this.product_ProdId = productProdId;
  }


  public String getColor_ColorId() {
    return color_ColorId;
  }

  public void setColor_ColorId(String colorColorId) {
    this.color_ColorId = colorColorId;
  }


  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

}
