package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final String name;
    private final BigDecimal population;

    public Country(String name, String population) {
        this.name = name;
        this.population = new BigDecimal(population);
    }

    public BigDecimal getPeopleQuantity() {
        return population;
    }

}
