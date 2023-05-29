package by.mlechka.xml.common;

public enum SweetXmlTag {

    CANDIES("candies"),
    CANDY("candy"),
    CHOCOLATE("chocolate"),
    VALUE("value"),
    NAME("name"),
    ENERGY("energy"),
    ENERGY_AMOUNT("energyAmount"),
    ENERGY_UNIT("energyUnit"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
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
    VARIETY("variety"),
    EXPIRATION_DATE("expiration-date")
    ;

    private String value;

    SweetXmlTag(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
