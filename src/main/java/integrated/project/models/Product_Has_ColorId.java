package integrated.project.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
public class Product_Has_ColorId implements Serializable {
//    @Column(name = "Product_ProdId")
    private String productProdId;
//    @Column(name = "Color_ColorId")
    private String colorColorId;

    public Product_Has_ColorId(String product_ProdId, String color_ColorId) {
        this.productProdId = product_ProdId;
        this.colorColorId = color_ColorId;
    }

    public Product_Has_ColorId() {
    }

    public String getProductProdId() {
        return productProdId;
    }

    public void setProductProdId(String productProdId) {
        this.productProdId = productProdId;
    }

    public String getColorColorId() {
        return colorColorId;
    }

    public void setColorColorId(String colorColorId) {
        this.colorColorId = colorColorId;
    }
}
