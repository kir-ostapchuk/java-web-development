package com.epam.jwd.task.model;

import java.util.List;

public abstract class Figure {
    protected List<Point> points;

    public Figure(List<Point> points) {
        this.points = points;
    }

    public Point getPoint(int ind) {
        return points.get(ind);
    }
}
