package com.epam.jwd.model;

import java.util.List;

public interface FigureFactory<T extends Figure> {
    T createFigure(List<Point> points);
}
