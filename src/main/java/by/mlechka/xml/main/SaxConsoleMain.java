package by.mlechka.xml.main;

import by.mlechka.xml.exception.CustomException;
import by.mlechka.xml.handler.ConsoleSweetHandler;
import by.mlechka.xml.handler.SweetErrorHandler;
import by.mlechka.xml.reader.PropertiesStreamReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.nio.file.Path;

public class SaxConsoleMain {

    public static final String FILE_NAME = "xml/sweets.xml";

    public static void main(String[] args) throws CustomException {
        try {
            PropertiesStreamReader propertiesStreamReader = new PropertiesStreamReader();
            Path path = propertiesStreamReader.getFileFromResource(FILE_NAME);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(new ConsoleSweetHandler());
            reader.setErrorHandler(new SweetErrorHandler());
            reader.parse(String.valueOf(path));
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
