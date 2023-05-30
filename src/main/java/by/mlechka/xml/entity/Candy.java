package by.mlechka.xml.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Candy extends Sweet{

    private String variety;

    public Candy() {
    }

    public Candy(String id, Boolean vegan, String name, Energy energy, List<Ingredient> ingredients, Value value, String manufacturer, String variety, LocalDateTime expirationDate, String variety1) {
        super(id, vegan, name, energy, ingredients, value, manufacturer, expirationDate);
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

        Candy candy = (Candy) o;

        return Objects.equals(variety, candy.variety);
    }

    @Override
    public int hashCode() {
        return variety != null ? variety.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candy{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", vegan=").append(getVegan());
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", energy=").append(getEnergy());
        sb.append(", ingredients=").append(getIngredients());
        sb.append(", value=").append(getValue());
        sb.append(", manufacturer='").append(getManufacturer()).append('\'');
        sb.append(", expirationDate=").append(getExpirationDate());
        sb.append(", variety='").append(variety).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
