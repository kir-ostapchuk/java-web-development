package com.epam.jwd.task.model.factories.impl.line;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Line extends Figure {

    private List<Point> points;

    Line(List<Point> points, String name, Color color) {
        super(name, color);
        if (points == null) {
            throw new NullPointerException();
        }
        checkAndAddPoints(points);
    }

    private void checkAndAddPoints(List<Point> points) {
        if (points.size() >= 2) {
            this.points = points.subList(0, 2);
        }
    }

    public Point getPoint(int ind) {
        return points.get(ind);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Line: " + points.get(0) + ", " + points.get(1);
    }
}
