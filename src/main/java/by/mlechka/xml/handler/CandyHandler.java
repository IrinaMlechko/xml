package by.mlechka.xml.handler;

import by.mlechka.xml.common.CandyXmlTag;
import by.mlechka.xml.common.ChocolateTypeEnum;
import by.mlechka.xml.entity.Candy;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandyHandler extends DefaultHandler {
    private Set<Candy> candies;
    private Candy current;
    private CandyXmlTag currentXmlTag;
    private EnumSet<CandyXmlTag> withText;
    private static final String ELEMENT_CANDY = "candy";

    public CandyHandler() {
        candies = new HashSet<Candy>();
        withText = EnumSet.range(CandyXmlTag.NAME, CandyXmlTag.VARIETY);
    }
    public Set<Candy> getCandies() {
        return candies;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_CANDY.equals(qName)) {
            current = new Candy();
            current.setId(attrs.getValue(0));
        } else {
            CandyXmlTag temp = CandyXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_CANDY.equals(qName)) {
            candies.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag!= null) {
            switch (currentXmlTag) {
                case NAME -> current.setName(data);
                //TODO: why does it not work like Value?
                case ENERGY -> current.setEnergy(new Candy.Energy());
                case ENERGYAMOUNT -> current.getEnergy().setAmount(Integer.parseInt(data));
                //TODO: how to work with default value if tag present in xml?
                case ENERGYUNIT -> current.getEnergy().setUnit(data != "" ? data : "kcal");
                case INGREDIENTS -> current.setIngredients(new ArrayList<>());
                case INGREDIENT -> current.getIngredients().add(new Candy.IngredientType());
                case INGREDIENTNAME -> current.getIngredients().get(current.getIngredients().size()-1).setName(data);
                case AMOUNT -> current.getIngredients().get(current.getIngredients().size()-1).setAmount(Integer.parseInt(data));
                case UNIT -> current.getIngredients().get(current.getIngredients().size()-1).setUnit(data);
                case PROTEIN -> current.getValue().setProtein(Integer.parseInt(data));
                case FAT -> current.getValue().setFat(Integer.parseInt(data));
                case CARBOHYDRATES -> current.getValue().setCarbohydrates(Integer.parseInt(data));
                case MANUFACTURER -> current.setManufacturer(data);
                case VARIETY -> current.setVariety(data);
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}

