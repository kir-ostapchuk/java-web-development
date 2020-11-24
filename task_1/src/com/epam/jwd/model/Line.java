package com.epam.jwd.model;

public class Line {
    private Point dot1;
    private Point dot2;

    public Line(Point dot1, Point dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
    }

    public Point getDot1() {
        return dot1;
    }

    public void setDot1(Point dot1) {
        this.dot1 = dot1;
    }

    public Point getDot2() {
        return dot2;
    }

    public void setDot2(Point dot2) {
        this.dot2 = dot2;
    }

    @Override
    public String toString() {
        return "Line{" +
                "dot1=" + dot1 +
                ", dot2=" + dot2 +
                '}';
    }
}
