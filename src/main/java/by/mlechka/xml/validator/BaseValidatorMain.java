package by.mlechka.xml.validator;

import by.mlechka.xml.handler.SweetErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class BaseValidatorMain {

    static Logger logger = LogManager.getLogger(BaseValidatorMain.class);

    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "src/main/resources/xml/sweets.xml";
        String schemaName = "src/main/resources/xml/sweets.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.setErrorHandler(new SweetErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            logger.error(fileName + " is not correct or valid");
        }
    }
}