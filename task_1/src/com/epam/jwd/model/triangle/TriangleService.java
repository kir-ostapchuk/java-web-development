package com.epam.jwd.model.triangle;

import com.epam.jwd.strategy.TriangleCalculator;

public class TriangleService {
    private TriangleCalculator strategy;

    public double calculateArea(Triangle triangle) {
        return strategy.calculateArea(triangle);
    }

    public double calculatePerimeter(Triangle triangle) {
        return strategy.calculatePerimeter(triangle);
    }
}
