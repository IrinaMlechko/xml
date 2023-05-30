package by.mlechka.xml.main;

import by.mlechka.xml.builder.CandiesDomBuilder;

public class DomMain {
    public static void main(String[] args) {
        CandiesDomBuilder domBuilder = new CandiesDomBuilder();
        domBuilder.buildSetSweets("src/main/resources/xml/sweets.xml");
        System.out.println(domBuilder.getSweets());}
}