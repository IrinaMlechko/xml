package by.mlechka.xml.type;

public enum CandyXmlTag {

    SWEETS("sweets"),
    CANDY("candy"),
    CHOCOLATE("chocolate"),
    VALUE("value"),
    NAME("name"),
    ENERGY("energy"),
    ENERGY_AMOUNT("energy-amount"),
    ENERGY_UNIT("energy-unit"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    VANILLA("vanilla"),
    INGREDIENTS("ingredients"),
    INGREDIENT ("ingredient"),
    INGREDIENT_NAME ("ingredient-name"),
    AMOUNT ("amount"),
    UNIT ("unit"),
    PROTEIN("protein"),
    FAT("fat"),
    CARBOHYDRATES("carbohydrates"),
    MANUFACTURER("manufacturer"),
    VARIETY("variety"),
    SHAPE("shape"),
    EXPIRATION_DATE("expiration-date"),
    CHOCOLATE_TYPE("chocolate-type")
    ;

    private String value;

    CandyXmlTag(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
