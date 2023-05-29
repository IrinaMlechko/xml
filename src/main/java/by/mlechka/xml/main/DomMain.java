package by.mlechka.xml.main;

import by.mlechka.xml.builder.CandiesDomBuilder;

public class DomMain {
    public static void main(String[] args) {
    CandiesDomBuilder domBuilder = new CandiesDomBuilder();
        domBuilder.buildSetCandies("src/main/resources/xml/candies.xml");
        System.out.println(domBuilder.getCandies());}
}
