package integrated.project.Entitys;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "products")
//@JsonIdentityInfo(
//
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//
//        property = "prodId")
//@JsonIgnoreProperties(value = "brand")
public class Product {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String prodId;
    private String prodName;
    private String description;
    private double price;
    private Date date;
    private String image;
    @ManyToOne
    @JoinColumn(name = "brands_brandId",nullable = false)

    private Brand brand;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @ManyToMany(targetEntity = Color.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
//    @JoinTable(
//            name="products_colors",
//            joinColumns=
//            @JoinColumn( name="Products_ProdId", referencedColumnName="ProdId"),
//            inverseJoinColumns=@JoinColumn(name="Colors_ColorId", referencedColumnName="ColorId"))


    private List<Color> colors;
//    @OneToMany(mappedBy = "product")
//
//    private List<ProductsColors> colors = new ArrayList<>();

    public String getProdId() {
        return prodId;
    }

//    public List<ProductsColors> getColors() {
//        return colors;
//    }
//
//    public void setColors(List<ProductsColors> colors) {
//        this.colors = colors;
//    }

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
