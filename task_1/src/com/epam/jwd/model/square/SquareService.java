package com.epam.jwd.model.square;

import com.epam.jwd.strategy.SquareCalculator;

public class SquareService {
    SquareCalculator strategy;

    public double calculateArea(Square square) {
        return strategy.calculateArea(square);
    }

    public double calculatePerimeter(Square square) {
        return strategy.calculatePerimeter(square);
    }
}
