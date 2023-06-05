package by.mlechka.xml.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Sweet {

    private String id;
    private Boolean vegan;
    private String name;
    private Energy energy;
    private List<Ingredient> ingredients = new ArrayList<>();
    private Value value = new Value();
    private String manufacturer;
    private LocalDateTime expirationDate;

    public Sweet() {
    }

    public Sweet(String id, Boolean vegan, String name, Energy energy, List<Ingredient> ingredients, Value value, String manufacturer,LocalDateTime expirationDate) {
        this.id = id;
        this.vegan = vegan;
        this.name = name;
        this.energy = energy;
        this.ingredients = ingredients;
        this.value = value;
        this.manufacturer = manufacturer;
        this.expirationDate = expirationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Energy getEnergy() {
        return energy;
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sweet{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", energy=").append(energy);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", value=").append(value);
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", expirationDate=").append(expirationDate);
        sb.append('}');
        return sb.toString();
    }

}

