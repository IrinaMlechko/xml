//package by.mlechka.xml.main;
//
//import by.mlechka.xml.handler.ConsoleCandyHandler;
//import org.xml.sax.SAXException;
//import org.xml.sax.XMLReader;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.parsers.SAXParser;
//import javax.xml.parsers.SAXParserFactory;
//import java.io.IOException;
//public class SaxConsoleMain {
//    public static void main(String[] args) {
//        try {
//// SAX parser creating & configuring
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            SAXParser parser = factory.newSAXParser();
//            XMLReader reader = parser.getXMLReader();
//            reader.setContentHandler(new ConsoleCandyHandler());
////            reader.setErrorHandler(new CandyErrorHandler());
//            reader.parse("src/main/resources/xml/sweets.xml");
//        } catch (SAXException | IOException | ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//    }
//}
