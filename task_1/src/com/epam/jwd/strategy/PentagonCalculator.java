package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

import java.util.List;

public enum PentagonCalculator implements AreaCalculator, PerimeterCalculator {
    INSTANCE;

    @Override
    public double calculatePerimeter(List<Point> points) {
        return 0;
    }

    @Override
    public double calculateArea(List<Point> points) {
        return 0;
    }

    private static double calculateSide(Point point1, Point point2) {
        return Math.hypot(
                point1.getX() - point2.getX(),
                point1.getY() - point2.getY());
    }
}
