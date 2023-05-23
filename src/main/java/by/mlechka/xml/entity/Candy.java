package by.mlechka.xml.entity;

import by.mlechka.xml.common.ChocolateTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class Candy {

    private String id;
    private String name;
    private Energy energy;
//    private IngredientType ingredientType = new IngredientType();
    private List<IngredientType> ingredients = new ArrayList<>();
    private Value value = new Value();
    private String manufacturer;
    private String variety;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nId:");
        sb.append(id).append("\nName: ").append(name);
        sb.append("\nEnergy: ").append(energy);
        sb.append("\nIngredients: ").append(ingredients);
        sb.append("\nManufacturer: ").append(manufacturer);
        sb.append("\nVariety: ").append(variety).append('\n');
        return sb.toString();
    }

    public Candy() {
    }

    public Candy(String id, String name, Energy energy, List<IngredientType> ingredients, Value value, String manufacturer, String variety) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.ingredients = ingredients;
        this.value = value;
        this.manufacturer = manufacturer;
        this.variety = variety;
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


    public static class Ingredients {

        private List<IngredientType> ingredients = new ArrayList<>();

        public List<IngredientType> getIngredients() {
            return ingredients;
        }

        public void setIngredients(List<IngredientType> ingredients) {
            this.ingredients = ingredients;
        }
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
            sb.append(name).append(" - ").append(amount).append(" ").append(unit);
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

