package by.mlechka.xml.entity;

import java.util.Objects;

public class Ingredient {

    private String name;
    private int amount;
    private String unit;

    public Ingredient() {
    }

    public Ingredient(String name, int amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append("name='").append(name).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", unit='").append(unit).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (amount != that.amount) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + amount;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
