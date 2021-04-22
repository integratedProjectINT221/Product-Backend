package integrated.project.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {
  @Id
  private String brandId;
  private String brandName;


  public String getBrandId() {
    return brandId;
  }

  public void setBrandId(String brandId) {
    this.brandId = brandId;
  }


  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

}
