package by.mlechka.xml.main;

import by.mlechka.xml.builder.CandiesDomBuilder;

public class Main {
    public static void main(String[] args) {
//    CandiesSaxBuilder saxBuilder = new CandiesSaxBuilder();
//        saxBuilder.buildSetCandies("src/main/resources/xml/sweets.xml");
//        System.out.println(saxBuilder.getCandies());}

    CandiesDomBuilder domBuilder = new CandiesDomBuilder();
        domBuilder.buildSetCandies("src/main/resources/xml/sweets.xml");
        System.out.println(domBuilder.getCandies());}
}
