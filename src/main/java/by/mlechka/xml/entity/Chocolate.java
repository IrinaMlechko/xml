package by.mlechka.xml.entity;

import by.mlechka.xml.common.ChocolateVariety;
import by.mlechka.xml.common.Shape;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public class Chocolate extends Sweet{
    private ChocolateVariety variety;
    private Shape shape;

    public Chocolate (){
            }

    public Chocolate(String id, Boolean vegan, String name, Energy energy, List<Ingredient> ingredients, Value value, String manufacturer, LocalDateTime expirationDate, ChocolateVariety variety, Shape shape) {
        super(id, vegan, name, energy, ingredients, value, manufacturer, expirationDate);
        this.variety = variety;
        this.shape = shape;
    }

    public ChocolateVariety getVariety() {
        return variety;
    }

    public void setVariety(ChocolateVariety variety) {
        this.variety = variety;
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

        if (variety != chocolate.variety) return false;
        return shape == chocolate.shape;
    }

    @Override
    public int hashCode() {
        int result = variety != null ? variety.hashCode() : 0;
        result = 31 * result + (shape != null ? shape.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chocolate{");
        sb.append("variety=").append(variety);
        sb.append(", shape=").append(shape);
        sb.append('}');
        return sb.toString();
    }
}
