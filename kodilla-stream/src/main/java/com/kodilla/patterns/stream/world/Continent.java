package com.kodilla.patterns.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final String name;
    private final List<Country> countryList = new ArrayList<>();

    public Continent(String name) {
        this.name = name;
        if (name.equals("Africa")){
            countryList.add(new Country("South Africa", "10000000"));
            countryList.add(new Country("Congo", "10000000"));
            countryList.add(new Country("Nigeria", "10000000"));
            countryList.add(new Country("Kenya", "10000000"));
            countryList.add(new Country("Egypt", "10000000"));

        } else if (name.equals("Europe")){
            countryList.add(new Country("Poland", "10000000"));
            countryList.add(new Country("Germany","10000000"));
            countryList.add(new Country("France", "10000000"));
            countryList.add(new Country("Italy", "10000000"));
            countryList.add(new Country("Spain", "10000000"));
        } else if (name.equals("Asia")){
            countryList.add(new Country("China", "10000000"));
            countryList.add(new Country("India", "10000000"));
            countryList.add(new Country("Japan", "10000000"));
            countryList.add(new Country("South Korea", "10000000"));
            countryList.add(new Country("Indonesia", "10000000"));
        }
    }

    public String getName() {
        return name;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
