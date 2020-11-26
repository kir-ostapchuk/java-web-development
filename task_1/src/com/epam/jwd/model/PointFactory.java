package com.epam.jwd.model;

public class PointFactory implements FigureFactory {
    public Point createPoint(int x, int y) {
        Point point = new Point(x, y);
        return point;
    }
}
