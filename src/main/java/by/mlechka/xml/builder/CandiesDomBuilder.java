package by.mlechka.xml.builder;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.mlechka.xml.entity.Candy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CandiesDomBuilder {
    private Set<Candy> candies;
    private DocumentBuilder docBuilder;
    public CandiesDomBuilder() {
        candies = new HashSet<Candy>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace(); // log
        }
    }
    public Set<Candy> getCandies() {
        return candies;
    }
    public void buildSetCandies(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
// getting a list of <candy> child elements
            NodeList candiesList = root.getElementsByTagName("candy");
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = buildCandy(candyElement);
                candies.add(candy);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
    }
    private Candy buildCandy(Element candyElement) {
        Candy candy = new Candy();
// add null check

        candy.setId(candyElement.getAttribute("id"));
        candy.setName(getElementTextContent(candyElement, "name"));
//        Candy.Energy energy = getElementTextContent(candyElement, "energy");
//        candy.setEnergy(energy);
        Candy.Ingredients ingredients = new Candy.Ingredients();
// init an address object
        Element ingredientsElement =
                (Element) candyElement.getElementsByTagName("ingredients").item(0);
//        ingredients.setCountry(getElementTextContent(ingredientsElement, "country"));
//        ingredients.setCity(getElementTextContent(ingredientsElement, "city"));
//        ingredients.setStreet(getElementTextContent(ingredientsElement, "street"));
//        candy.setLogin(candyElement.getAttribute("login"));
        return candy;
    }
    // get the text content of the tag
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

