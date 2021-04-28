package integrated.project.Entitys;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String prodId;
    private String prodName;
    private String description;
    private double price;
    private Date date;
    private String image;

    @ManyToMany(targetEntity = Color.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
//    @JoinTable(
//            name="products_has_colors",
//            joinColumns=
//            @JoinColumn( name="Products_ProdId", referencedColumnName="ProdId"),
//            inverseJoinColumns=@JoinColumn(name="Colors_ColorId", referencedColumnName="ColorId"))
    private List<Color> colors;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }
}
