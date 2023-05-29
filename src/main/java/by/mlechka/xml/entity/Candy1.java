package by.mlechka.xml.entity;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Candy1 extends Sweet{

    private String variety;

    public Candy1() {
    }

    public Candy1(String id, String name, Energy energy, List<Ingredient> ingredients, Value value, String manufacturer, String variety, Instant expirationDate, String variety1) {
        super(id, name, energy, ingredients, value, manufacturer, expirationDate);
        this.variety = variety1;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy1 candy1 = (Candy1) o;

        return Objects.equals(variety, candy1.variety);
    }

    @Override
    public int hashCode() {
        return variety != null ? variety.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candy1{");
        sb.append("variety='").append(variety).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
