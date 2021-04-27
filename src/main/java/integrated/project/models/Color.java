package integrated.project.models;


import javax.persistence.*;

@Entity
public class Color {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private String colorId;
  private String colorName;



  public String getColorId() {
    return colorId;
  }

  public void setColorId(String colorId) {
    this.colorId = colorId;
  }


  public String getColorName() {
    return colorName;
  }

  public void setColorName(String colorName) {
    this.colorName = colorName;
  }

}
