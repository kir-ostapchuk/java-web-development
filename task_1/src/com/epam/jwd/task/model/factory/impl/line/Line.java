package com.epam.jwd.task.model.factory.impl.line;

import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.List;

public final class Line extends Figure {

    Line(List<Point> points, String name, Color color) {
        super(points.subList(0, 2), name, color);
    }

    @Override
    public String toString() {
        return "Line: " + getPoints().get(0) + ", " + getPoints().get(1);
    }
}
