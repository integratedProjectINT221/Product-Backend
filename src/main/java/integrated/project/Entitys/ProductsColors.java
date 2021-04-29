//package integrated.project.Entitys;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table(name = "products_colors")
//
//public class ProductsColors {
//
//  @EmbeddedId
//  private ProductsColorsId ProductsColorsId;
//
//  @ManyToOne
//  @MapsId("productsProdId")
//  @JoinColumn(name = "Products_ProdId")
//  @JsonIgnore
//
//  Product product;
//
//  @ManyToOne
//  @MapsId("colorsColorId")
//  @JsonIgnore
//  @JoinColumn(name = "Colors_ColorId")
//
//  Color color;
//
//  public ProductsColors() {
//  }
//
//  public ProductsColors(integrated.project.Entitys.ProductsColorsId productsColorsId, Product product, Color color) {
//    ProductsColorsId = new ProductsColorsId(product.getProdId(),color.getColorId());
//    this.product = product;
//    this.color = color;
//  }
//
//  public integrated.project.Entitys.ProductsColorsId getProductsColorsId() {
//    return ProductsColorsId;
//  }
//
//  public void setProductsColorsId(integrated.project.Entitys.ProductsColorsId productsColorsId) {
//    ProductsColorsId = productsColorsId;
//  }
//
//  public Product getProduct() {
//    return product;
//  }
//
//  public void setProduct(Product product) {
//    this.product = product;
//  }
//
//  public Color getColor() {
//    return color;
//  }
//
//  public void setColor(Color color) {
//    this.color = color;
//  }
//
////  public String getProductsProdId() {
////    return productsProdId;
////  }
////
////  public void setProductsProdId(String productsProdId) {
////    this.productsProdId = productsProdId;
////  }
////
////
////  public String getColorsColorId() {
////    return colorsColorId;
////  }
////
////  public void setColorsColorId(String colorsColorId) {
////    this.colorsColorId = colorsColorId;
////  }
//
//}
