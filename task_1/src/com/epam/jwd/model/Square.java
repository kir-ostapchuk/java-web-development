package com.epam.jwd.model;

import com.epam.jwd.strategy.PerimeterStrategy;
import com.epam.jwd.strategy.SquareStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Square implements PerimeterStrategy, SquareStrategy {
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    private double side1;
    private double side2;
    private double side3;
    private double side4;
    private double side5;
    private double side6;

    public Square(Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;

        side1 = calculateSide(point1, point2);
        side2 = calculateSide(point2, point3);
        side3 = calculateSide(point3, point4);
        side4 = calculateSide(point1, point4);
        side5 = calculateSide(point2, point4);
        side6 = calculateSide(point1, point3);
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

    private double calculateSide(Point point1, Point point2) {
        return Math.hypot(
                point1.getX() - point2.getX(),
                point1.getY() - point2.getY());
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
    public double calculatePerimeter() {
        List<Double> sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        sides.add(side4);
        sides.add(side5);
        sides.add(side6);
        Collections.sort(sides);
        return sides.get(0) * 4;
    }

    @Override
    public double calculateSquare() {
        List<Double> sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        sides.add(side4);
        sides.add(side5);
        sides.add(side6);
        Collections.sort(sides);

        return sides.get(0) * sides.get(0);
    }
}
