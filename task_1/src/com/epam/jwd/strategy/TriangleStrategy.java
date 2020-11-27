package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Triangle;

public enum TriangleStrategy implements GeometricCalcStrategy<Triangle> {
    INSTANCE;

    @Override
    public double calculatePerimeter(Triangle triangle) {
        double side1 = calculateSide(triangle.getPoint1(), triangle.getPoint2());
        double side2 = calculateSide(triangle.getPoint2(), triangle.getPoint3());
        double side3 = calculateSide(triangle.getPoint1(), triangle.getPoint3());

        return side1 + side2 + side3;
    }

    @Override
    public double calculateSquare(Triangle triangle) {
        double side1 = calculateSide(triangle.getPoint1(), triangle.getPoint2());
        double side2 = calculateSide(triangle.getPoint2(), triangle.getPoint3());
        double side3 = calculateSide(triangle.getPoint1(), triangle.getPoint3());

        double p = (side1 + side2 + side3) / 2;
        return  Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    private static double calculateSide(Point point1, Point point2) {
        return Math.hypot(
                point1.getX() - point2.getX(),
                point1.getY() - point2.getY());
    }


}
