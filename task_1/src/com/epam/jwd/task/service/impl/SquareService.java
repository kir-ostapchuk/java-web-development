package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.model.factories.impl.square.Square;
import com.epam.jwd.task.service.FigureService;
import com.epam.jwd.task.calculations.impl.SquareCalculator;

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
