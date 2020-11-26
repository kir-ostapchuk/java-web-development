package com.epam.jwd.model;

public class TriangleFactory {
    public Triangle createTriangle(int x1, int y1,
                           int x2, int y2,
                           int x3, int y3) {
        PointFactory pointFactory = new PointFactory();
        Point point1 = pointFactory.createPoint(x1, y1);
        Point point2 = pointFactory.createPoint(x2, y2);
        Point point3 = pointFactory.createPoint(x3, y3);
        return new Triangle(point1, point2, point3);
    }
}
