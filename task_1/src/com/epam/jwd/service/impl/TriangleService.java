package com.epam.jwd.service.impl;

import com.epam.jwd.service.FigureService;
import com.epam.jwd.model.factories.impl.triangle.Triangle;
import com.epam.jwd.calculations.impl.TriangleCalculator;

public class TriangleService implements FigureService<Triangle> {
    private TriangleCalculator strategy;

    @Override
    public double calculateArea(Triangle triangle) {
        return strategy.calculateArea(triangle);
    }

    @Override
    public double calculatePerimeter(Triangle triangle) {
        return strategy.calculatePerimeter(triangle);
    }
}
