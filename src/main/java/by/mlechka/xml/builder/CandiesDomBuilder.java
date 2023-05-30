package by.mlechka.xml.builder;

import by.mlechka.xml.entity.*;
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

    public SweetsDomBuilder() {
        sweets = new HashSet<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("error by creating doc builder");
        }
    }
    public Set<Sweet> getSweets() {
        return sweets;
    }
    public void buildSetSweets(String filename) {
        Document doc;
        try {
//add null check
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList candiesList = root.getElementsByTagName("candy");
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = buildCandy(candyElement);
                sweets.add(candy);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
    private Candy buildCandy(Element candyElement){
        Candy candy = new Candy();
        candy.setId(candyElement.getAttribute("id"));
        candy.setVegan(Boolean.valueOf(candyElement.getAttribute("vegan")));
        candy.setName(getElementTextContent(candyElement, "name"));
        Energy energy = new Energy();
        Element energyElement = (Element) candyElement.getElementsByTagName("energy").item(0);
        energy.setAmount(Integer.parseInt(getElementTextContent(candyElement, "energyAmount")));
        energy.setUnit(getElementTextContent(candyElement, "energyUnit"));
        candy.setEnergy(energy);
        Value value = new Value();
        Element valueElement = (Element) candyElement.getElementsByTagName("value").item(0);
        value.setProtein(Integer.parseInt(getElementTextContent(candyElement, "protein")));
        value.setFat(Integer.parseInt(getElementTextContent(candyElement, "fat")));
        value.setCarbohydrates(Integer.parseInt(getElementTextContent(candyElement, "carbohydrates")));
        candy.setValue(value);
        candy.setManufacturer(getElementTextContent(candyElement, "manufacturer"));
        candy.setVariety(getElementTextContent(candyElement, "variety"));
        candy.setExpirationDate(LocalDateTime.parse(getElementTextContent(candyElement, "expiration-date")));
        Element ingredientsElement = (Element) candyElement.getElementsByTagName("ingredients").item(0);
        List<Ingredient> ingredients = buildIngredients(ingredientsElement);
        candy.setIngredients(ingredients);
        return candy;
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
        ingredient.setName(getElementTextContent(ingredientElement, "ingredientName"));
        ingredient.setAmount(Integer.parseInt(getElementTextContent(ingredientElement, "amount")));
        ingredient.setUnit(getElementTextContent(ingredientElement, "unit"));
        return ingredient;
    }
}

