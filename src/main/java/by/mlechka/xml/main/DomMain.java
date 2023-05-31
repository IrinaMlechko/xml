package by.mlechka.xml.main;

import by.mlechka.xml.builder.SweetsDomBuilder;
import by.mlechka.xml.reader.PropertiesStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomMain {

    public static final String FILE_NAME = "xml/sweets.xml";

    public static void main(String[] args) throws URISyntaxException, IOException {
        PropertiesStreamReader propertiesStreamReader = new PropertiesStreamReader();
        Path path = propertiesStreamReader.getFileFromResource(FILE_NAME);
        SweetsDomBuilder domBuilder = new SweetsDomBuilder();
        domBuilder.buildSetSweets(String.valueOf(path));
        System.out.println(domBuilder.getSweets());
    }
}
