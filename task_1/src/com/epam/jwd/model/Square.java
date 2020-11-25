package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Square implements Validator, DefaultValidator{
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    public Square(Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                ", point4=" + point4 +
                '}';
    }

    @Override
    public boolean validate() {
        List<Double> sides = new ArrayList<>();

        double side1 = Math.hypot(point1.getX() - point2.getX(), point1.getY() - point2.getY());
        double side2 = Math.hypot(point2.getX() - point3.getX(), point2.getY() - point3.getY());
        double side3 = Math.hypot(point3.getX() - point4.getX(), point3.getY() - point4.getY());
        double side4 = Math.hypot(point1.getX() - point4.getX(), point1.getY() - point4.getY());
        double side5 = Math.hypot(point1.getX() - point3.getX(), point1.getY() - point3.getY());
        double side6 = Math.hypot(point2.getX() - point4.getX(), point2.getY() - point4.getY());

        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        sides.add(side4);
        sides.add(side5);
        sides.add(side6);

        Collections.sort(sides);

        return (sides.get(0).equals(sides.get(3)) && sides.get(4).equals(sides.get(5)));
    }

    @Override
    public boolean defaultValidate() {
        return !(point1.equals(point2) ||
                 point2.equals(point3) ||
                 point3.equals(point4) ||
                 point4.equals(point1) ||
                 point2.equals(point4) ||
                 point1.equals(point3));
    }
}
