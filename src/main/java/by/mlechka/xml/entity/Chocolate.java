package by.mlechka.xml.entity;

import by.mlechka.xml.common.ChocolateVariety;
import by.mlechka.xml.common.Shape;

import java.time.LocalDateTime;
import java.util.List;

public class Chocolate extends Sweet{
    
    private ChocolateVariety chocolateType;
    private Shape shape;

    public Chocolate (){
            }

    public Chocolate(String id, Boolean vegan, String name, Energy energy, List<Ingredient> ingredients, Value value, String manufacturer, LocalDateTime expirationDate, ChocolateVariety chocolateType, Shape shape) {
        super(id, vegan, name, energy, ingredients, value, manufacturer, expirationDate);
        this.chocolateType = chocolateType;
        this.shape = shape;
    }

    public ChocolateVariety getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateVariety chocolateType) {
        this.chocolateType = chocolateType;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chocolate chocolate = (Chocolate) o;

        if (chocolateType != chocolate.chocolateType) return false;
        return shape == chocolate.shape;
    }

    @Override
    public int hashCode() {
        int result = chocolateType != null ? chocolateType.hashCode() : 0;
        result = 31 * result + (shape != null ? shape.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chocolate{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", vegan=").append(getVegan());
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", energy=").append(getEnergy());
        sb.append(", ingredients=").append(getIngredients());
        sb.append(", value=").append(getValue());
        sb.append(", manufacturer='").append(getManufacturer()).append('\'');
        sb.append(", expirationDate=").append(getExpirationDate());
        sb.append(", chocolateType=").append(chocolateType);
        sb.append(", shape=").append(shape);
        sb.append('}');
        return sb.toString();
    }
}
