package integrated.project.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
  @Id
  private String prodId;
  private String prodName;

  private String description;
  private double price;
  @Column(name = "brand_BrandId")
  private String brandBrandId;
  private String image;


  public String getProdId() {
    return prodId;
  }

  public void setProdId(String prodId) {
    this.prodId = prodId;
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

}
