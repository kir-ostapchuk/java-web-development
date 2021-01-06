package com.epam.jwd.task.model.factory.impl.square;

import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.List;

public final class Square extends Figure {

    Square(List<Point> points, String name, Color color) {
        super(points, name, color);
    }

    @Override
    public String toString() {
        return "Square: " +
                getPoints().get(0) + ", " +
                getPoints().get(1) + ", " +
                getPoints().get(2) + ", " +
                getPoints().get(3);
    }
}
