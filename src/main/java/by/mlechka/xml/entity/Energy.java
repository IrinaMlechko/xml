package by.mlechka.xml.entity;

public class Energy {

    private int amount;
    private String unit;

    public Energy(int amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public Energy() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n\t");
        sb.append(amount).append(" ").append(unit);
        return sb.toString();
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
