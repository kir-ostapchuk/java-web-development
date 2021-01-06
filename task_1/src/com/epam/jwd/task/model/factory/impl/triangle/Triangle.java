package com.epam.jwd.task.model.factory.impl.triangle;

import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.List;

public final class Triangle extends Figure {

    Triangle(List<Point> points, String name, Color color) {
        super(points, name, color);
    }

    @Override
    public String toString() {
        return "Triangle: " +
                getPoints().get(0) + ", " +
                getPoints().get(1) + ", " +
                getPoints().get(2);
    }
}