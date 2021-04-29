package integrated.project.services;



import java.util.List;

public class BrandModel {

  private String brandName;
  private List<ProductModel> products;

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public List<ProductModel> getProducts() {
    return products;
  }

  public void setProducts(List<ProductModel> products) {
    this.products = products;
  }
}
