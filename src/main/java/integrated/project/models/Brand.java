//package integrated.project.models;
//
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "brand")
//public class Brand {
//  @Id
////  @Column(name = "BrandId")
//  private String brandId;
//  private String brandName;
//
//  @OneToMany(mappedBy = "brand")
////  @JoinColumn(name = "Brand_BrandId")
//  private List<Product> products;
//
//
//  public String getBrandId() {
//    return brandId;
//  }
//
//  public void setBrandId(String brandId) {
//    this.brandId = brandId;
//  }
//
//
//  public String getBrandName() {
//    return brandName;
//  }
//
//  public void setBrandName(String brandName) {
//    this.brandName = brandName;
//  }
//
//  public List<Product> getProducts() {
//    return products;
//  }
//
//  public void setProducts(List<Product> products) {
//    this.products = products;
//  }
//}
