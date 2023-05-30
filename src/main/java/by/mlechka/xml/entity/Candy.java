package by.mlechka.xml.entity;

import by.mlechka.xml.type.Variety;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Candy extends Sweet{

    private Variety variety;

    public Candy() {
    }

    public Candy(String id, Boolean vegan, String name, Energy energy, List<Ingredient> ingredients, Value value, String manufacturer, LocalDateTime expirationDate, Variety variety) {
        super(id, vegan, name, energy, ingredients, value, manufacturer, expirationDate);
        this.variety = variety;
    }

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
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
        final StringBuilder sb = new StringBuilder("\n Candy{");
        sb.append("\n\t id='").append(getId()).append('\'');
        sb.append(", \n\t vegan=").append(getVegan());
        sb.append(", \n\t name='").append(getName()).append('\'');
        sb.append(", \n\t energy=").append(getEnergy());
        sb.append(", \n\t ingredients=").append(getIngredients());
        sb.append(", ").append(getValue());
        sb.append(", \n\t manufacturer='").append(getManufacturer()).append('\'');
        sb.append(", \n\t expirationDate=").append(getExpirationDate());
        sb.append(", \n\t variety='").append(variety).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
