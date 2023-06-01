package by.mlechka.xml.main;

import by.mlechka.xml.builder.SweetsDomBuilder;
import by.mlechka.xml.exception.CustomException;
import by.mlechka.xml.reader.PropertiesStreamReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class DomMain {

    public static final String FILE_NAME = "xml/sweets.xml";

    public static void main(String[] args) throws CustomException {
        PropertiesStreamReader propertiesStreamReader = new PropertiesStreamReader();
        Path path = propertiesStreamReader.getFileFromResource(FILE_NAME);
        SweetsDomBuilder domBuilder = new SweetsDomBuilder();
        domBuilder.buildSetSweets(String.valueOf(path));
        System.out.println(domBuilder.getSweets());
    }
}
