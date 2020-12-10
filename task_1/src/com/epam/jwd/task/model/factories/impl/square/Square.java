package com.epam.jwd.task.model.factories.impl.square;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.List;

public final class Square extends Figure {

    static List<Square> squaresPool;

    Square(List<Point> points) {
        super(points);
    }
}
