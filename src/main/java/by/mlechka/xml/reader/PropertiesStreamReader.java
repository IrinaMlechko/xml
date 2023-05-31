package by.mlechka.xml.reader;

import by.mlechka.xml.main.DomMain;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PropertiesStreamReader {

    public Path getFileFromResource(String fileName) throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
//        URL url = DomMain.class.getClassLoader().getResource("xml/sweets.xml");
        Path path = Paths.get(resource.toURI());
        if(resource==null){
            throw new IllegalArgumentException("File not found " + fileName);
        }
        return path;
    }
}
