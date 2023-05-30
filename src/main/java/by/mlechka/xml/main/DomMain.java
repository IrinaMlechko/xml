package by.mlechka.xml.main;

import by.mlechka.xml.builder.SweetsDomBuilder;

public class DomMain {
    public static void main(String[] args) {
        SweetsDomBuilder domBuilder = new SweetsDomBuilder();
        domBuilder.buildSetSweets("src/main/resources/xml/sweets.xml");
        System.out.println(domBuilder.getSweets());
         }
}