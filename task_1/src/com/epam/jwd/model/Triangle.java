package com.epam.jwd.model;

import com.epam.jwd.strategy.PerimeterStrategy;
import com.epam.jwd.strategy.SquareStrategy;

public class Triangle implements Validator, DefaultValidator, PerimeterStrategy, SquareStrategy {
    private Point point1;
    private Point point2;
    private Point point3;

    private double side1;
    private double side2;
    private double side3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;

        side1 = calculateSide(point1, point2);
        side2 = calculateSide(point2, point3);
        side3 = calculateSide(point1, point3);
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

    @Override
    public String toString() {
        return "Triangle{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                '}';
    }

    private double calculateSide(Point point1, Point point2) {
        return Math.hypot(
                point1.getX() - point2.getX(),
                point1.getY() - point2.getY());
    }

    @Override
    public boolean validate() {
        return (side1 + side2 > side3) || (side1 + side3 > side2) || (side2 + side3 > side1);
    }

    @Override
    public boolean defaultValidate() {
        return !(point1.equals(point2) || point2.equals(point3) || point1.equals(point3));
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double calculateSquare() {
        double p = (side1 + side2 + side3) / 2;
        return  Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
}