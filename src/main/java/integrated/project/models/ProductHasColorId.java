package integrated.project.models;

import javax.persistence.Id;
import java.io.Serializable;

public class ProductHasColorId implements Serializable {
    private String product_ProdId;

    private String color_ColorId;

    public ProductHasColorId(String product_ProdId, String color_ColorId) {
        this.product_ProdId = product_ProdId;
        this.color_ColorId = color_ColorId;
    }

    public ProductHasColorId() {
    }
}
