package integrated.project.models;

import javax.persistence.*;

@Entity
@IdClass(ProductHasColorId.class)
public class Product_Has_Color {
  @Column(name = "Product_ProdId")
  @Id
  private String productProdId;
  @Column(name = "Color_ColorId")
  @Id
  private String colorColorId;
//  @EmbeddedId
//  private ProductHasColorId ProducthasColorId;
  private long quantity;

//  public ProductHasColorId getProducthasColorId() {
//    return ProducthasColorId;
//  }
//
//  public void setProducthasColorId(ProductHasColorId producthasColorId) {
//    ProducthasColorId = producthasColorId;
//  }

  public String getProductProdId() {
    return productProdId;
  }

  public void setProductProdId(String productProdId) {
    this.productProdId = productProdId;
  }


  public String getColor_ColorId() {
    return colorColorId;
  }

  public void setColor_ColorId(String colorColorId) {
    this.colorColorId = colorColorId;
  }


  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

}
