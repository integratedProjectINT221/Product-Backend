//package integrated.project.Entitys;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class ProductsColorsId implements Serializable {
//
//    @Column(name = "products_colors")
//    private String productsProdId;
//    @Column(name = "Colors_ColorId")
//    private String colorsColorId;
//
//    public ProductsColorsId() {
//    }
//
//    public ProductsColorsId(String productsProdId, String colorsColorId) {
//        this.productsProdId = productsProdId;
//        this.colorsColorId = colorsColorId;
//    }
//
//    public String getProductsProdId() {
//        return productsProdId;
//    }
//
//    public void setProductsProdId(String productsProdId) {
//        this.productsProdId = productsProdId;
//    }
//
//    public String getColorsColorId() {
//        return colorsColorId;
//    }
//
//    public void setColorsColorId(String colorsColorId) {
//        this.colorsColorId = colorsColorId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ProductsColorsId that = (ProductsColorsId) o;
//        return Objects.equals(productsProdId, that.productsProdId) && Objects.equals(colorsColorId, that.colorsColorId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(productsProdId, colorsColorId);
//    }
//}
