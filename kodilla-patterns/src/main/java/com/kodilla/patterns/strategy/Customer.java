package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.BuyPredictor;

public sealed class Customer
        permits CorporateCustomer, IndividualCustomer, IndividualYoungCustomer {

    private final String name;
    protected BuyPredictor buyPredicator;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String predict() {
        return buyPredicator.predictWhatToBuy();
    }

    public void setBuyingStrategy(BuyPredictor buyPredicator) {
        this.buyPredicator = buyPredicator;
    }
}
