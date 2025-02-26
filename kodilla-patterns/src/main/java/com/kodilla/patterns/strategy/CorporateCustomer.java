package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.BalancedPredictor;

public final class CorporateCustomer extends Customer {

    public CorporateCustomer(String name) {
        super(name);
        this.buyPredicator = new BalancedPredictor();
    }
}
