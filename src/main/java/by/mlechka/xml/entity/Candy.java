package by.mlechka.xml.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Candy {

    private String id;
    private Boolean vegan;
    private String name;
    private Energy energy;
    private List<IngredientType> ingredients = new ArrayList<>();
    private Value value = new Value();
    private String manufacturer;
    private String variety;
    private LocalDateTime expirationDate;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n Candy{");
        sb.append("\n\t id='").append(id).append('\'');
        sb.append(", \n\t vegan='").append(vegan).append('\'');
        sb.append(", \n\t name='").append(name).append('\'');
        sb.append(", \n\t energy=").append(energy);
        sb.append(", \n\t ingredients=").append(ingredients);
        sb.append(", ").append(value);
        sb.append(", \n\t manufacturer='").append(manufacturer).append('\'');
        sb.append(", \n\t variety='").append(variety).append('\'');
        sb.append(", \n\t expirationDate=").append(expirationDate);
        sb.append('}');
        return sb.toString();
    }

    public Candy() {
    }

    public Candy(String id, Boolean vegan, String name, Energy energy, List<IngredientType> ingredients, Value value, String manufacturer, String variety, LocalDateTime expirationDate) {
        this.id = id;
        this.vegan = vegan;
        this.name = name;
        this.energy = energy;
        this.ingredients = ingredients;
        this.value = value;
        this.manufacturer = manufacturer;
        this.variety = variety;
        this.expirationDate = expirationDate;
    }

    public String getId() {
        return id;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
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

    public List<IngredientType> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientType> ingredients) {
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

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public static class IngredientType {
        private String name;
        private int amount;
        private String unit;

        public IngredientType(String name, int amount, String unit) {
            this.name = name;
            this.amount = amount;
            this.unit = unit;
        }

        public IngredientType() {
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\n\t");
            sb.append("\t").append(name).append(" - ").append(amount).append(" ").append(unit);
            return sb.toString();
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

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

    public static class Value {

        private int protein;
        private int fat;
        private int carbohydrates;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\n\t value:\n\t\t protein:");
            sb.append(protein).append("\n\t\t fat: ").append(fat);
            sb.append("\n\t\t carbohydrates: ").append(carbohydrates).append('\n');
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
            final StringBuilder sb = new StringBuilder("");
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

