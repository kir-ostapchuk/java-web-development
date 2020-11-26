package com.epam.jwd.model;

public class SquareFactory {
    public Square createSquare(int x1, int y1,
                               int x2, int y2,
                               int x3, int y3,
                               int x4, int y4) {
        PointFactory pointFactory = new PointFactory();
        Point point1 = pointFactory.createPoint(x1, y1);
        Point point2 = pointFactory.createPoint(x2, y2);
        Point point3 = pointFactory.createPoint(x3, y3);
        Point point4 = pointFactory.createPoint(x4, y4);
        return new Square(point1, point2, point3, point4);
    }
}
