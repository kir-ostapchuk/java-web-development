package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.triangle.Triangle;

public class TriangleStrategyLazySingleton implements CalculateAreaStrategy<Triangle>, CalculatePerimeterStrategy<Triangle> {

    private TriangleStrategyLazySingleton() {
    }

    @Override
    public double calculatePerimeter(Triangle triangle) {
        double side1 = calculateSide(triangle.getPoint(0), triangle.getPoint(1));
        double side2 = calculateSide(triangle.getPoint(1), triangle.getPoint(2));
        double side3 = calculateSide(triangle.getPoint(0), triangle.getPoint(2));

        return side1 + side2 + side3;
    }

    @Override
    public double calculateSquare(Triangle triangle) {
        double side1 = calculateSide(triangle.getPoint(1), triangle.getPoint(1));
        double side2 = calculateSide(triangle.getPoint(0), triangle.getPoint(2));
        double side3 = calculateSide(triangle.getPoint(0), triangle.getPoint(2));

        double p = (side1 + side2 + side3) / 2;
        return  Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    private static double calculateSide(Point point1, Point point2) {
        return Math.hypot(
                point1.getX() - point2.getX(),
                point1.getY() - point2.getY());
    }

    private static class LazySingletonHolder {
        private final static TriangleStrategyLazySingleton instance = new TriangleStrategyLazySingleton();
    }

    public static TriangleStrategyLazySingleton getInstance() {
        return LazySingletonHolder.instance;
    }
}
