package integrated.project.services;


import java.util.List;


public class ProductModel {
  private String prodName;
  private String description;
  private double price;
  private String image;
  private BrandModel brandModel;
  private List<ColorModel> colors;


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


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public BrandModel getBrand() {
    return brandModel;
  }

  public void setBrand(BrandModel brandModel) {
    this.brandModel = brandModel;
  }

  public List<ColorModel> getColors() {
    return colors;
  }

  public void setColors(List<ColorModel> colors) {
    this.colors = colors;
  }
}
