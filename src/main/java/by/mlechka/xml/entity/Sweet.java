package by.mlechka.xml.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public abstract class Sweet {

    private String id;
    private String name;
    private Energy energy;
    private List<Ingredient> ingredients = new ArrayList<>();
    private Value value = new Value();
    private String manufacturer;
    private Instant expirationDate;

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

    public Sweet() {
    }

    public Sweet(String id, String name, Energy energy, List<Ingredient> ingredients, Value value, String manufacturer,Instant expirationDate) {
        this.id = id;
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

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }

      public static class Value {

        private int protein;
        private int fat;
        private int carbohydrates;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\nValue:\n\tProtein:");
            sb.append(protein).append("\n\tFat: ").append(fat);
            sb.append("\n\tCarbohydrates: ").append(carbohydrates).append('\n');
            return sb.toString();
        }

        public Value(int protein, int fat, int carbohydrates) {
            this.protein = protein;
            this.fat = fat;
            this.carbohydrates = carbohydrates;
        }

        public Value() {
        }

        public int getProtein() {
            return protein;
        }

        public void setProtein(int protein) {
            this.protein = protein;
        }


        public int getFat() {
            return fat;
        }

        public void setFat(int fat) {
            this.fat = fat;
        }


        public int getCarbohydrates() {
            return carbohydrates;
        }

        public void setCarbohydrates(int carbohydrates) {
            this.carbohydrates = carbohydrates;
        }
    }
    public static class Energy {

        private int amount;
        private String unit;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\n\t");
            sb.append(amount).append(" ").append(unit);
            return sb.toString();
        }

        public Energy(int amount, String unit) {
            this.amount = amount;
            this.unit = unit;
        }

        public Energy() {
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
    }
}

