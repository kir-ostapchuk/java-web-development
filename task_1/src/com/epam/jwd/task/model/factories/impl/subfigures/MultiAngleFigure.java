package com.epam.jwd.task.model.factories.impl.subfigures;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Color;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class MultiAngleFigure extends Figure {

    public static Set<MultiAngleFigure> multiAngleFiguresPool = new HashSet<>();
    private List<Point> points;

    MultiAngleFigure(List<Point> points, String name, Color color) {
        super(name, color);
        if (points != null) {
            this.points = points;
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
        MultiAngleFigure that = (MultiAngleFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Multianglefigure: ");
        for (Point point : points) {
            result.append(point.toString());
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length() - 1);
        return String.valueOf(result);
    }
}
