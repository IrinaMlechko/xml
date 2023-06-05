package by.mlechka.xml.builder;

import by.mlechka.xml.entity.*;
import by.mlechka.xml.type.ChocolateVariety;
import by.mlechka.xml.type.Shape;
import by.mlechka.xml.type.SweetXmlTag;
import by.mlechka.xml.type.Variety;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SweetsStaxBuilder {

    public static final String XML_ATTRIBUTE_ID = "id";
    public static final String XML_ATTRIBUTE_VEGAN = "vegan";
    static Logger logger = LogManager.getLogger(SweetsDomBuilder.class);
    private Set<Sweet> sweets;
    private XMLInputFactory inputFactory;

    public SweetsStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        sweets = new HashSet<>();
    }

    public Set<Sweet> getSweets() {
        return sweets;
    }

    public void buildSetSweets(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(SweetXmlTag.CANDY.getValue())) {
                        Candy candy = buildCandy(reader);
                        sweets.add(candy);
                    } else if (name.equals(SweetXmlTag.CHOCOLATE.getValue())) {
                        Chocolate chocolate = buildChocolate(reader);
                        sweets.add(chocolate);
                    }
                }
            }

        } catch (XMLStreamException | FileNotFoundException e) {
            logger.error("Error by reading or parsing file " + filename + " " + e.getMessage());
        } catch (IOException e) {
            logger.error("Error by reading or parsing file " + filename + " " + e.getMessage());
        }
    }

    private Candy buildCandy(XMLStreamReader reader) throws XMLStreamException {
        Candy candy = new Candy();
        candy.setId(reader.getAttributeValue(null, XML_ATTRIBUTE_ID));
        candy.setVegan(Boolean.valueOf(reader.getAttributeValue(null, XML_ATTRIBUTE_VEGAN)));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_"))) {
                        case NAME -> {
                            candy.setName(getXMLText(reader));
                        }
                        case ENERGY -> {
                            candy.setEnergy(getXMLEnergy(reader));
                        }
                        case INGREDIENTS -> {
                            candy.setIngredients(getXMLIngredients(reader));
                        }
                        case VALUE -> {
                            candy.setValue(getXMLValue(reader));
                        }
                        case MANUFACTURER -> {
                            candy.setManufacturer(getXMLText(reader));
                        }
                        case EXPIRATION_DATE -> {
                            candy.setExpirationDate(LocalDateTime.parse(getXMLText(reader)));
                        }
                        case VARIETY -> {
                            candy.setVariety(Variety.valueOf((getXMLText(reader).toUpperCase())));
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == SweetXmlTag.CANDY) {
                        return candy;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <candy>");
    }

    private Chocolate buildChocolate(XMLStreamReader reader) throws XMLStreamException {
        Chocolate chocolate = new Chocolate();
        chocolate.setId(reader.getAttributeValue(null, XML_ATTRIBUTE_ID));
        chocolate.setVegan(Boolean.valueOf(reader.getAttributeValue(null, XML_ATTRIBUTE_VEGAN)));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_"))) {
                        case NAME -> {
                            chocolate.setName(getXMLText(reader));
                        }
                        case ENERGY -> {
                            chocolate.setEnergy(getXMLEnergy(reader));
                        }
                        case INGREDIENTS -> {
                            chocolate.setIngredients(getXMLIngredients(reader));
                        }
                        case VALUE -> {
                            chocolate.setValue(getXMLValue(reader));
                        }
                        case MANUFACTURER -> {
                            chocolate.setManufacturer(getXMLText(reader));
                        }
                        case EXPIRATION_DATE -> {
                            chocolate.setExpirationDate(LocalDateTime.parse(getXMLText(reader)));
                        }
                        case SHAPE -> {
                            chocolate.setShape(Shape.valueOf((getXMLText(reader).toUpperCase())));
                        }
                        case CHOCOLATE_TYPE -> {
                            chocolate.setChocolateType(ChocolateVariety.valueOf((getXMLText(reader).toUpperCase().replace("-", "_"))));
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == SweetXmlTag.CHOCOLATE) {
                        return chocolate;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <chocolate>");
    }

    private Energy getXMLEnergy(XMLStreamReader reader) throws XMLStreamException {
        Energy energy = new Energy();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_"))) {
                        case ENERGY_AMOUNT:
                            energy.setAmount(Integer.parseInt(reader.getElementText()));
                            break;
                        case ENERGY_UNIT:
                            energy.setUnit(reader.getElementText());
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == SweetXmlTag.ENERGY) {
                        return energy;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <energy>");
    }

    private List<Ingredient> getXMLIngredients(XMLStreamReader reader) throws XMLStreamException {
        List<Ingredient> ingredients = new ArrayList<>();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals(SweetXmlTag.INGREDIENT.getValue())) {
                        Ingredient ingredient = buildIngredient(reader);
                        ingredients.add(ingredient);
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == SweetXmlTag.INGREDIENTS) {
                        return ingredients;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <ingredients>");
    }

    private Ingredient buildIngredient(XMLStreamReader reader) throws XMLStreamException {
        Ingredient ingredient = new Ingredient();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_"))) {
                        case INGREDIENT_NAME:
                            ingredient.setName(getXMLText(reader));
                            break;
                        case AMOUNT:
                            ingredient.setAmount(Integer.parseInt(getXMLText(reader)));
                            break;
                        case UNIT:
                            ingredient.setUnit(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == SweetXmlTag.INGREDIENT) {
                        return ingredient;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <ingredients>");
    }

    private Value getXMLValue(XMLStreamReader reader) throws XMLStreamException {
        Value value = new Value();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_"))) {
                        case PROTEIN:
                            value.setProtein(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FAT:
                            value.setFat(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CARBOHYDRATES:
                            value.setCarbohydrates(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (SweetXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == SweetXmlTag.VALUE) {
                        return value;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <value>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}

