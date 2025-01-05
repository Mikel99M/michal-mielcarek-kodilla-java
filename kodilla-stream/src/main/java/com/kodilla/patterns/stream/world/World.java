package com.kodilla.patterns.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {

    private final List<Continent> continentList = new ArrayList<>();

    public World() {
        continentList.add(new Continent("Europe"));
        continentList.add(new Continent("Asia"));
        continentList.add(new Continent("Africa"));
    }

    public List<Continent> getContinentList() {
        return continentList;
    }

    public BigDecimal getPeopleQuantity() {
        return continentList.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
