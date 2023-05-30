package by.mlechka.xml.entity;

    public class Value {

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

