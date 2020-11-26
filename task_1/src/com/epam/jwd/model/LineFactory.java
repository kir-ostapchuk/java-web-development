package com.epam.jwd.model;

public class LineFactory {
    public Line createLine(int x1, int y1, int x2, int y2) {
        PointFactory pointFactory = new PointFactory();
        Point point1 = pointFactory.createPoint(x1, y1);
        Point point2 = pointFactory.createPoint(x2, y2);
        return new Line(point1, point2);
    }
}
