package integrated.project.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Product_ColorsId implements Serializable {

    private int ProdId;

    private int ColorId;

    public Product_ColorsId(){}
    public Product_ColorsId(int prodId, int colorId) {
        ProdId = prodId;
        ColorId = colorId;
    }

    public int getProdId() {
        return ProdId;
    }

    public void setProdId(int prodId) {
        ProdId = prodId;
    }

    public int getColorId() {
        return ColorId;
    }

    public void setColorId(int colorId) {
        ColorId = colorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product_ColorsId that = (Product_ColorsId) o;
        return ProdId == that.ProdId && ColorId == that.ColorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProdId, ColorId);
    }
}
