package by.mlechka.xml.handler;

import by.mlechka.xml.entity.*;
import by.mlechka.xml.type.ChocolateVariety;
import by.mlechka.xml.type.Shape;
import by.mlechka.xml.type.SweetXmlTag;
import by.mlechka.xml.type.Variety;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class SweetHandler extends DefaultHandler {
    private Set<Sweet> sweets;
    private Sweet current;
    private SweetXmlTag currentXmlTag;
    private EnumSet<SweetXmlTag> withText;
    private static final String ELEMENT_CANDY = "candy";
    private static final String ELEMENT_CHOCOLATE = "chocolate";
    private static final String ATTRIBUTE_ID = "id";
    private static final String ATTRIBUTE_VEGAN = "vegan";

    public SweetHandler() {
        sweets = new HashSet<>();
        withText = EnumSet.range(SweetXmlTag.NAME, SweetXmlTag.EXPIRATION_DATE);
    }
    public Set<Sweet> getSweets() {
        return sweets;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_CANDY.equals(qName)) {
            current = new Candy();
            String id = attrs.getValue(ATTRIBUTE_ID);
            current.setId(id);
            String vegan = attrs.getValue(ATTRIBUTE_VEGAN);
            current.setVegan(vegan != null ? Boolean.parseBoolean(vegan) : false);
        } else if(ELEMENT_CHOCOLATE.equals(qName)){
            current = new Chocolate();
            String id = attrs.getValue(ATTRIBUTE_ID);
            current.setId(id);
            String vegan = attrs.getValue(ATTRIBUTE_VEGAN);
            current.setVegan(vegan != null ? Boolean.parseBoolean(vegan) : false);
        }
        else {
            SweetXmlTag temp = SweetXmlTag.valueOf(qName.toUpperCase().replace("-", "_"));
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_CANDY.equals(qName) || ELEMENT_CHOCOLATE.equals(qName)) {
            sweets.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag!= null) {
            switch (currentXmlTag) {
                case NAME -> current.setName(data);
                case ENERGY -> current.setEnergy(new Energy());
                case ENERGY_AMOUNT -> current.getEnergy().setAmount(Integer.parseInt(data));
                //TODO: how to work with default value if tag present in xml?
                case ENERGY_UNIT -> current.getEnergy().setUnit(data != "" ? data : "kcal");
                case INGREDIENTS -> current.setIngredients(new ArrayList<>());
                case INGREDIENT -> current.getIngredients().add(new Ingredient());
                case INGREDIENT_NAME -> current.getIngredients().get(current.getIngredients().size()-1).setName(data);
                case AMOUNT -> current.getIngredients().get(current.getIngredients().size()-1).setAmount(Integer.parseInt(data));
                case UNIT -> current.getIngredients().get(current.getIngredients().size()-1).setUnit(data);
                case PROTEIN -> current.getValue().setProtein(Integer.parseInt(data));
                case FAT -> current.getValue().setFat(Integer.parseInt(data));
                case CARBOHYDRATES -> current.getValue().setCarbohydrates(Integer.parseInt(data));
                case MANUFACTURER -> current.setManufacturer(data);
                case EXPIRATION_DATE -> current.setExpirationDate(LocalDateTime.parse(data));
//                case CHOCOLATE_TYPE -> current.set
                case VARIETY -> {
                    if (current instanceof Candy) {
                        ((Candy) current).setVariety(Enum.valueOf(Variety.class, data.toUpperCase().replace("-", "_")));
                    }
                }
                case CHOCOLATE_TYPE -> {
                    if (current instanceof Chocolate) {
                        ((Chocolate) current).setChocolateType(Enum.valueOf(ChocolateVariety.class, data.toUpperCase().replace("-", "_")));
                    }
                }
                case SHAPE -> {
                    if (current instanceof Chocolate) {
                        ((Chocolate) current).setShape(Enum.valueOf(Shape.class, data.toUpperCase().replace("-", "_")));
                    }
                }
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}

