package by.mlechka.xml.builder;

import by.mlechka.xml.entity.Sweet;
import by.mlechka.xml.handler.SweetErrorHandler;
import by.mlechka.xml.handler.SweetHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class SweetsSaxBuilder {

    public Set<Sweet> sweets;
    private SweetHandler handler = new SweetHandler();
    private XMLReader reader;

    public SweetsSaxBuilder() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            reader = null;
        }
        reader.setErrorHandler(new SweetErrorHandler());
    }

    public Set<Sweet> getSweets() {
        return sweets;
    }

    public void buildSetSweets(String filename) {

        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        sweets = handler.getSweets();
    }
}
