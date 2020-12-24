package com.epam.jwd.task.calculation.impl;

import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factory.impl.triangle.Triangle;
import com.epam.jwd.task.calculation.AreaCalculator;
import com.epam.jwd.task.calculation.PerimeterCalculator;

public final class TriangleCalculatorLazySingleton implements AreaCalculator<Triangle>, PerimeterCalculator<Triangle> {

    private TriangleCalculatorLazySingleton() {
    }

    @Override
    public double calculatePerimeter(Triangle triangle) {
        double side1 = calculateSide(triangle.getPoint(0), triangle.getPoint(1));
        double side2 = calculateSide(triangle.getPoint(1), triangle.getPoint(2));
        double side3 = calculateSide(triangle.getPoint(0), triangle.getPoint(2));

        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea(Triangle triangle) {
        double side1 = calculateSide(triangle.getPoint(0), triangle.getPoint(1));
        double side2 = calculateSide(triangle.getPoint(1), triangle.getPoint(2));
        double side3 = calculateSide(triangle.getPoint(0), triangle.getPoint(2));

        double p = (side1 + side2 + side3) / 2;
        return  Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }


    // todo: move to more general class
    private static double calculateSide(Point point1, Point point2) {
        return Math.hypot(
                point1.getX() - point2.getX(),
                point1.getY() - point2.getY());
    }

    private static class LazySingletonHolder {
        private final static TriangleCalculatorLazySingleton instance = new TriangleCalculatorLazySingleton();
    }

    public static TriangleCalculatorLazySingleton getInstance() {
        return LazySingletonHolder.instance;
    }
}
