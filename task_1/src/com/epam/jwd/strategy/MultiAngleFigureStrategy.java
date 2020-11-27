package com.epam.jwd.strategy;

import com.epam.jwd.model.MultiAngleFigure;
import com.epam.jwd.model.Point;

public enum MultiAngleFigureStrategy implements GeometricCalcStrategy<MultiAngleFigure> {
    INSTANCE;

    @Override
    public double calculatePerimeter(MultiAngleFigure figure) {
        return 0;
    }

    @Override
    public double calculateSquare(MultiAngleFigure figure) {
        return 0;
    }

    private static double calculateSide(Point point1, Point point2) {
        return Math.hypot(
                point1.getX() - point2.getX(),
                point1.getY() - point2.getY());
    }
}
