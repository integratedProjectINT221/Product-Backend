package integrated.project.models;

import javax.persistence.*;

@Entity
@Table(name = "product_has_color")
//@IdClass(ProductHasColorId.class)
public class Product_Has_Color {
//  @Column(name = "Product_ProdId")
//  @Id
//  private String productProdId;
//  @Column(name = "Color_ColorId")
//  @Id
//  private String colorColorId;
  @EmbeddedId
  private Product_Has_ColorId Product_Has_ColorId;

  @ManyToOne
  @MapsId("productProdId")
  @JoinColumn(name = "Product_ProdId")
  Product product;

  @ManyToOne
  @MapsId("colorColorId")
  @JoinColumn(name = "Color_ColorId")
  Color color;
  private long quantity;
  public Product_Has_Color(){};
  public Product_Has_Color(integrated.project.models.Product_Has_ColorId product_Has_ColorId, Product product, Color color, long quantity) {
    Product_Has_ColorId = product_Has_ColorId;
    this.product = product;
    this.color = color;
    this.quantity = quantity;
  }

  public Product_Has_ColorId getProduct_Has_ColorId() {
    return Product_Has_ColorId;
  }

  public void setProduct_Has_ColorId(Product_Has_ColorId product_Has_ColorId) {
    Product_Has_ColorId = product_Has_ColorId;
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
