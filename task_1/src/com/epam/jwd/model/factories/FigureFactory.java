package com.epam.jwd.model.factories;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

import java.util.List;

public interface FigureFactory<T extends Figure> {
    T createFigure(List<Point> points) throws FigureException;
}
