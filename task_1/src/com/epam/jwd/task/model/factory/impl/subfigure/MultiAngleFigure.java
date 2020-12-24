package com.epam.jwd.task.model.factory.impl.subfigure;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Color;

import java.util.List;

public final class MultiAngleFigure extends Figure {

    MultiAngleFigure(List<Point> points, String name, Color color) {
        super(points, name, color);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Multianglefigure: ");
        for (Point point : getPoints()) {
            result.append(point.toString());
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length() - 1);
        return String.valueOf(result);
    }
}
