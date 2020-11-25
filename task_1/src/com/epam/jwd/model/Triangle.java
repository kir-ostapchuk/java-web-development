package com.epam.jwd.model;

public class Triangle implements Validator, DefaultValidator{
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
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

    @Override
    public boolean validate() {
        double line1 = Math.hypot(
                getPoint1().getX() - getPoint2().getX(),
                getPoint1().getY() - getPoint2().getY());

        double line2 = Math.hypot(
                getPoint1().getX() - getPoint3().getX(),
                getPoint1().getY() - getPoint3().getY());

        double line3 = Math.hypot(
                getPoint2().getX() - getPoint3().getX(),
                getPoint2().getY() - getPoint3().getY());

        return (line1 + line2 > line3) || (line1 + line3 > line2) || (line2 + line3 > line1);
    }

    @Override
    public boolean defaultValidate() {
        return !(point1.equals(point2) || point2.equals(point3) || point1.equals(point3));
    }
}