package integrated.project.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

//@Embeddable
public class ProductHasColorId implements Serializable {

    private String productProdId;

    private String colorColorId;

    public ProductHasColorId(String product_ProdId, String color_ColorId) {
        this.productProdId = product_ProdId;
        this.colorColorId = color_ColorId;
    }

    public ProductHasColorId() {
    }
}
