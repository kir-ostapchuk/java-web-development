package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.service.FigureService;
import com.epam.jwd.task.model.factories.impl.triangle.Triangle;
import com.epam.jwd.task.calculations.impl.TriangleCalculator;

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
