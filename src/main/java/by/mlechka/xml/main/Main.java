package by.mlechka.xml.main;

import by.mlechka.xml.builder.SweetsSaxBuilder;
import by.mlechka.xml.exception.CustomException;
import by.mlechka.xml.reader.PropertiesStreamReader;

import java.nio.file.Path;

public class Main {

    public static final String FILE_NAME = "xml/sweets.xml";

    public static void main(String[] args) throws CustomException {
        PropertiesStreamReader propertiesStreamReader = new PropertiesStreamReader();
        Path path = propertiesStreamReader.getFileFromResource(FILE_NAME);
        SweetsSaxBuilder saxBuilder = new SweetsSaxBuilder();
        saxBuilder.buildSetSweets(String.valueOf(path));
        System.out.println(saxBuilder.getSweets());}

}
