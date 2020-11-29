package com.epam.jwd.model;

import java.util.List;

public class Square {
    private List<Point> points;

    Square(List<Point> points) {
        this.points = points;
    }

    public Point getPoint(int ind) {
        return points.get(ind);
    }

//    public void setPoint1(Point point1) {
//        this.point1 = point1;
//    }

//    public void setPoint2(Point point2) {
//        this.point2 = point2;
//    }

//    public void setPoint3(Point point3) {
//        this.point3 = point3;
//    }

//    public void setPoint4(Point point4) {
//        this.point4 = point4;
//    }
}
