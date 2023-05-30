package by.mlechka.xml.main;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleMain {
    public static void main(String[] args) {
        Locale locale = new Locale("by");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("res.sweetdata", locale);
        System.out.println(resourceBundle.getString("Test"));
    }
}
