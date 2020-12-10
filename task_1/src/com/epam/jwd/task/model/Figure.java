package com.epam.jwd.task.model;

import java.util.List;
import java.util.Objects;

public abstract class Figure {

    protected List<Point> points;

    public Figure(List<Point> points) {
        this.points = points;
    }

    public Point getPoint(int ind) {
        return points.get(ind);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(points, figure.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
