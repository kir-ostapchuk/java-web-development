package com.epam.jwd.model;

import java.util.List;

public abstract class Figure {
    private List<Point> points;

    Figure(List<Point> points) {
        this.points = points;
    }

    public Point getPoint(int ind) {
        return points.get(ind);
    }
}
