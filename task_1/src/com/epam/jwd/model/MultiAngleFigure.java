package com.epam.jwd.model;

import java.util.List;

public class MultiAngleFigure {
    private List<Point> points;

    public MultiAngleFigure(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getSides() {
        return points.size();
    }
}
