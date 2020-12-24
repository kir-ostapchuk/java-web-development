package com.epam.jwd.task.view.factory.impl.square;

import com.epam.jwd.task.view.Figure;
import com.epam.jwd.task.view.Point;
import com.epam.jwd.task.view.Color;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Square extends Figure {

    private List<Point> points;

    Square(List<Point> points, String name, Color color) {
        super(name, color);
        if (points == null) {
            throw new NullPointerException();
        }
        checkAndAdd(points);
    }

    private void checkAndAdd(List<Point> points) {
        if (points.size() >= 4) {
            this.points = points.subList(0, 4);
        }
    }

    public Point getPoint(int ind) {
        return points.get(ind);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(points, square.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Square: " + points.get(0) + ", " + points.get(1) + ", " + points.get(2) + ", " + points.get(3);
    }
}
