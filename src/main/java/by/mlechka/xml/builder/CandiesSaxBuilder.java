package by.mlechka.xml.builder;

import by.mlechka.xml.CandyErrorHandler;
import by.mlechka.xml.entity.Candy;
import by.mlechka.xml.handler.CandyHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class CandiesSaxBuilder {

    public Set<Candy> candies;
    private CandyHandler handler = new CandyHandler();
    private XMLReader reader;

    public CandiesSaxBuilder() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            reader = null;
        }
        reader.setErrorHandler(new CandyErrorHandler());
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void buildSetCandies(String filename) {

        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        candies = handler.getCandies();
    }
}
