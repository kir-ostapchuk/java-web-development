package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.pentagon.Pentagon;

public enum PentagonCalculator implements AreaCalculator<Pentagon>, PerimeterCalculator<Pentagon>{
    INSTANCE;

    @Override
    public double calculateArea(Pentagon pentagon) {
        return 0;
    }

    @Override
    public double calculatePerimeter(Pentagon pentagon) {
        return 0;
    }

    private static double calculateSide(Point point1, Point point2) {
        return Math.hypot(
                point1.getX() - point2.getX(),
                point1.getY() - point2.getY());
    }

}
