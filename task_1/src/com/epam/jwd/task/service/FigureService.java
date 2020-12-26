package com.epam.jwd.task.service;

import com.epam.jwd.task.model.Point;

public class FigureService {
    public static double calculateSide(Point point1, Point point2) {
        return Math.hypot(
                point1.getX() - point2.getX(),
                point1.getY() - point2.getY());
    }
    public static int squareDistanceBetweenTwoPoints(Point p1, Point p2) {
        return (p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY());
    }
}
