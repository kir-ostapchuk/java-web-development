package com.epam.jwd.model.pentagon;

import com.epam.jwd.strategy.PentagonCalculator;

public class PentagonService {
    PentagonCalculator strategy;

    public double calculateArea(Pentagon pentagon) {
        return strategy.calculateArea(pentagon);
    }

    public double calculatePerimeter(Pentagon pentagon) {
        return strategy.calculatePerimeter(pentagon);
    }
}
