package com.epam.jwd.task.calculation.impl;

import com.epam.jwd.task.calculation.AreaCalculator;
import com.epam.jwd.task.calculation.PerimeterCalculator;
import com.epam.jwd.task.model.factory.impl.triangle.Triangle;
import com.epam.jwd.task.service.FigureService;

public enum TriangleCalculator implements AreaCalculator<Triangle>, PerimeterCalculator<Triangle> {

    INSTANCE;

    @Override
    public double calculatePerimeter(Triangle triangle) {
        double side1 = FigureService.calculateSide(triangle.getPoint(0), triangle.getPoint(1));
        double side2 = FigureService.calculateSide(triangle.getPoint(1), triangle.getPoint(2));
        double side3 = FigureService.calculateSide(triangle.getPoint(0), triangle.getPoint(2));

        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea(Triangle triangle) {
        double side1 = FigureService.calculateSide(triangle.getPoint(0), triangle.getPoint(1));
        double side2 = FigureService.calculateSide(triangle.getPoint(1), triangle.getPoint(2));
        double side3 = FigureService.calculateSide(triangle.getPoint(0), triangle.getPoint(2));

        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
}
