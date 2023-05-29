//package by.mlechka.xml.handler;
//
//import by.mlechka.xml.common.SweetXmlTag;
//import by.mlechka.xml.entity.Candy1;
//import by.mlechka.xml.entity.Chocolate;
//import by.mlechka.xml.entity.Ingredient;
//import by.mlechka.xml.entity.Sweet;
//import org.xml.sax.Attributes;
//import org.xml.sax.helpers.DefaultHandler;
//
//import java.util.ArrayList;
//import java.util.EnumSet;
//import java.util.HashSet;
//import java.util.Set;
//
//public class SweetHandler extends DefaultHandler {
//    private Set<Sweet> sweets;
//    private Sweet current;
//    private SweetXmlTag currentXmlTag;
//    private EnumSet<SweetXmlTag> withText;
//    private static final String ELEMENT_CANDY = "candy";
//    private static final String ELEMENT_CHOCOLATE = "chocolate";
//
//    public SweetHandler() {
//        sweets = new HashSet<Sweet>();
//        withText = EnumSet.range(SweetXmlTag.NAME, SweetXmlTag.VARIETY);
//    }
//    public Set<Sweet> getSweets() {
//        return sweets;
//    }
//    public void startElement(String uri, String localName, String qName, Attributes attrs) {
//        if (ELEMENT_CANDY.equals(qName)) {
//            current = new Candy1();
//            current.setId(attrs.getValue(0));
//        } else if(ELEMENT_CHOCOLATE.equals(qName)){
//            current = new Chocolate();
//            current.setId(attrs.getValue(0));
//        }
//        else {
//            SweetXmlTag temp = SweetXmlTag.valueOf(qName.toUpperCase());
//            if (withText.contains(temp)) {
//                currentXmlTag = temp;
//            }
//        }
//    }
//    public void endElement(String uri, String localName, String qName) {
//        if (ELEMENT_CANDY.equals(qName) || ELEMENT_CHOCOLATE.equals(qName)) {
//            sweets.add(current);
//        }
//    }
//    public void characters(char[] ch, int start, int length) {
//        String data = new String(ch, start, length).strip();
//        if (currentXmlTag!= null) {
//            switch (currentXmlTag) {
//                case NAME -> current.setName(data);
//                case ENERGY -> current.setEnergy(new Sweet.Energy());
//                case ENERGY_AMOUNT -> current.getEnergy().setAmount(Integer.parseInt(data));
//                //TODO: how to work with default value if tag present in xml?
//                case ENERGY_UNIT -> current.getEnergy().setUnit(data != "" ? data : "kcal");
//                case INGREDIENTS -> current.setIngredients(new ArrayList<>());
//                case INGREDIENT -> current.getIngredients().add(new Ingredient());
//                case INGREDIENTNAME -> current.getIngredients().get(current.getIngredients().size()-1).setName(data);
//                case AMOUNT -> current.getIngredients().get(current.getIngredients().size()-1).setAmount(Integer.parseInt(data));
//                case UNIT -> current.getIngredients().get(current.getIngredients().size()-1).setUnit(data);
//                case PROTEIN -> current.getValue().setProtein(Integer.parseInt(data));
//                case FAT -> current.getValue().setFat(Integer.parseInt(data));
//                case CARBOHYDRATES -> current.getValue().setCarbohydrates(Integer.parseInt(data));
//                case MANUFACTURER -> current.setManufacturer(data);
//                case VARIETY -> current.setVariety(data);
//                default -> throw new EnumConstantNotPresentException(
//                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
//            }
//        }
//        currentXmlTag = null;
//    }
//}
//
