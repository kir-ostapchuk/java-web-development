package com.epam.jwd.model;

public class Square {
    private Point dot1;
    private Point dot2;
    private Point dot3;
    private Point dot4;

    public Square(Point dot1, Point dot2, Point dot3, Point dot4) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.dot3 = dot3;
        this.dot4 = dot4;
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

    public Point getDot3() {
        return dot3;
    }

    public void setDot3(Point dot3) {
        this.dot3 = dot3;
    }

    public Point getDot4() {
        return dot4;
    }

    public void setDot4(Point dot4) {
        this.dot4 = dot4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "dot1=" + dot1 +
                ", dot2=" + dot2 +
                ", dot3=" + dot3 +
                ", dot4=" + dot4 +
                '}';
    }
}
