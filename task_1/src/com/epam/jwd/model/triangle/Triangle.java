package com.epam.jwd.model.triangle;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.TriangleStrategy;

import java.util.List;

public class Triangle extends Figure {
    private TriangleStrategy strategy;

    Triangle(List<Point> points) {
        super(points);
    }

    double calculateArea() {
        return strategy.calculateArea(points);
    }

    double calculatePerimeter() {
        return strategy.calculatePerimeter(points);
    }
}