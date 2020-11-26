package com.epam.jwd.model;

import java.util.List;

public interface FigureFactory<T> {
    T createFigure(List<Point> points);
}
