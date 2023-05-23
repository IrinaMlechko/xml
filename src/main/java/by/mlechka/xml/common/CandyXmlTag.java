package by.mlechka.xml.common;

public enum CandyXmlTag {

    CANDIES("candies"),
    CANDY("candy"),
    VALUE("value"),
    NAME("name"),
    ENERGY("energy"),
    ENERGYAMOUNT("energyAmount"),
    ENERGYUNIT("energyUnit"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    CHOCOLATE("chocolateType"),
    VANILLA("vanilla"),
    INGREDIENTS("ingredients"),
    INGREDIENT ("ingredient"),
    INGREDIENTNAME ("ingredientName"),
    AMOUNT ("amount"),
    UNIT ("unit"),
    PROTEIN("protein"),
    FAT("fat"),
    CARBOHYDRATES("carbohydrates"),
    MANUFACTURER("manufacturer"),
    VARIETY("variety")
    ;

    private String value;

    CandyXmlTag(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
