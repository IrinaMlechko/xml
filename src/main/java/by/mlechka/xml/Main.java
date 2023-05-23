package by.mlechka.xml;

import by.mlechka.xml.builder.CandiesSaxBuilder;

public class Main {
    public static void main(String[] args) {
    CandiesSaxBuilder saxBuilder = new CandiesSaxBuilder();
        saxBuilder.buildSetCandies("src/main/resources/xml/candies4.xml");
        System.out.println(saxBuilder.getCandies());}
}
