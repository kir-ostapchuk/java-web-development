package com.epam.jwd.service.impl;

import com.epam.jwd.service.FigureService;
import com.epam.jwd.model.triangle.Triangle;
import com.epam.jwd.strategy.TriangleCalculator;

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
