package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.triangle.Triangle;

import java.util.List;

public enum TriangleStrategy implements AreaCalculator, PerimeterCalculator<Triangle> {
    INSTANCE;

    @Override
    public double calculatePerimeter(Triangle triangle) {
        double side1 = calculateSide(triangle.getPoint(0), triangle.getPoint(1));
        double side2 = calculateSide(triangle.getPoint(1), triangle.getPoint(2));
        double side3 = calculateSide(triangle.getPoint(0), triangle.getPoint(2));

        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea(List<Point> points) {
        double side1 = calculateSide(points.get(0), points.get(1));
        double side2 = calculateSide(points.get(1), points.get(2));
        double side3 = calculateSide(points.get(0), points.get(2));

        double p = (side1 + side2 + side3) / 2;
        return  Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    private static double calculateSide(Point point1, Point point2) {
        return Math.hypot(
                point1.getX() - point2.getX(),
                point1.getY() - point2.getY());
    }
}
