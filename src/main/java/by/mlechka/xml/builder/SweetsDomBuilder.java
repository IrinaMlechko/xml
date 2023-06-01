package by.mlechka.xml.builder;

import by.mlechka.xml.type.ChocolateVariety;
import by.mlechka.xml.type.Shape;
import by.mlechka.xml.entity.*;
import by.mlechka.xml.type.SweetXmlTag;
import by.mlechka.xml.type.Variety;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SweetsDomBuilder {
    private Set<Sweet> sweets;
    private DocumentBuilder docBuilder;
    static Logger logger = LogManager.getLogger(SweetsDomBuilder.class);
    public static final String XML_ATTRIBUTE_ID = "id";
    public static final String XML_ATTRIBUTE_VEGAN = "vegan";
    public static final String DEFAULT_ENERGY_UNIT = "kcal" ;
    public static final String SWEET_TYPE_CANDY = "candy" ;
    public static final String SWEET_TYPE_CHOCOLATE = "chocolate" ;

    public SweetsDomBuilder() {
        sweets = new HashSet<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Error by creating doc builder");
        }
    }
    public Set<Sweet> getSweets() {
        return sweets;
    }

    public void buildSetSweets(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList sweetsList = root.getChildNodes();
            for (int i = 0; i < sweetsList.getLength(); i++) {
                Node sweetNode = sweetsList.item(i);
                if (sweetNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element sweetElement = (Element) sweetNode;
                    Sweet sweet = buildSweet(sweetElement);
                    sweets.add(sweet);
                }
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private Sweet buildSweet(Element sweetElement) {
        String sweetType = sweetElement.getTagName();
        switch (sweetType) {
            case SWEET_TYPE_CANDY:
                return buildCandy(sweetElement);
            case SWEET_TYPE_CHOCOLATE:
                return buildChocolate(sweetElement);
            default:
                throw new IllegalArgumentException("Unknown sweet type: " + sweetType);
        }
    }

    private Candy buildCandy(Element sweetElement){
        Candy candy = new Candy();
        candy = (Candy) buildSweet(candy, sweetElement);
        candy.setVariety(Variety.valueOf(getElementTextContent(sweetElement, SweetXmlTag.VARIETY.getValue()).toUpperCase()));
        return candy;
    }

    private Sweet buildSweet(Sweet sweet, Element sweetElement){
        sweet.setId(sweetElement.getAttribute(XML_ATTRIBUTE_ID));
        sweet.setVegan(Boolean.valueOf(sweetElement.getAttribute(XML_ATTRIBUTE_VEGAN)));
        sweet.setName(getElementTextContent(sweetElement, SweetXmlTag.NAME.getValue()));
        Energy energy = new Energy();
        Element energyElement = (Element) sweetElement.getElementsByTagName(SweetXmlTag.ENERGY.getValue()).item(0);
        energy.setAmount(Integer.parseInt(getElementTextContent(energyElement, SweetXmlTag.ENERGY_AMOUNT.getValue())));
        energy.setUnit(getElementTextContent(energyElement, SweetXmlTag.ENERGY_UNIT.getValue()));
        if(energy.getUnit().isEmpty()){
            energy.setUnit(DEFAULT_ENERGY_UNIT);
        }
        sweet.setEnergy(energy);
        Value value = new Value();
        Element valueElement = (Element) sweetElement.getElementsByTagName(SweetXmlTag.VALUE.getValue()).item(0);
        value.setProtein(Integer.parseInt(getElementTextContent(valueElement, SweetXmlTag.PROTEIN.getValue())));
        value.setFat(Integer.parseInt(getElementTextContent(valueElement, SweetXmlTag.FAT.getValue())));
        value.setCarbohydrates(Integer.parseInt(getElementTextContent(valueElement, SweetXmlTag.CARBOHYDRATES.getValue())));
        sweet.setValue(value);
        sweet.setManufacturer(getElementTextContent(sweetElement, SweetXmlTag.MANUFACTURER.getValue()));
        sweet.setExpirationDate(LocalDateTime.parse(getElementTextContent(sweetElement, SweetXmlTag.EXPIRATION_DATE.getValue())));
        Element ingredientsElement = (Element) sweetElement.getElementsByTagName(SweetXmlTag.INGREDIENTS.getValue()).item(0);
        List<Ingredient> ingredients = buildIngredients(ingredientsElement);
        sweet.setIngredients(ingredients);
        return sweet;
    }
    private Chocolate buildChocolate(Element sweetElement){
        Chocolate chocolate = new Chocolate();
        chocolate = (Chocolate) buildSweet(chocolate, sweetElement);
        chocolate.setChocolateType(ChocolateVariety.valueOf(getElementTextContent(sweetElement, SweetXmlTag.CHOCOLATE_TYPE.getValue()).toUpperCase().replace("-","_")));
        chocolate.setShape(Shape.valueOf(getElementTextContent(sweetElement, SweetXmlTag.SHAPE.getValue()).toUpperCase().replace("-","_")));
        return chocolate;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    private List<Ingredient> buildIngredients(Element ingredientsElement) {
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        NodeList ingredientList = ingredientsElement.getElementsByTagName("ingredient");
        for (int i = 0; i < ingredientList.getLength(); i++) {
            Element ingredientElement = (Element) ingredientList.item(i);
            Ingredient ingredient = buildIngredient(ingredientElement);
            ingredients.add(ingredient);
        }
        return ingredients;
    }

    private Ingredient buildIngredient(Element ingredientElement) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(getElementTextContent(ingredientElement, "ingredient-name"));
        ingredient.setAmount(Integer.parseInt(getElementTextContent(ingredientElement, "amount")));
        ingredient.setUnit(getElementTextContent(ingredientElement, "unit"));
        return ingredient;
    }
}

