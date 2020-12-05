package com.epam.jwd.service.impl;

import com.epam.jwd.model.square.Square;
import com.epam.jwd.service.FigureService;
import com.epam.jwd.strategy.SquareCalculator;

public class SquareService implements FigureService<Square> {
    private SquareCalculator strategy;

    @Override
    public double calculateArea(Square square) {
        return strategy.calculateArea(square);
    }

    @Override
    public double calculatePerimeter(Square square) {
        return strategy.calculatePerimeter(square);
    }
}
