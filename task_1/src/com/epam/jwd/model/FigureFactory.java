package com.epam.jwd.model;

import com.epam.jwd.exception.FigureNotExistException;

import java.util.List;

public interface FigureFactory<T extends Figure> {
    T createFigure(List<Point> points) throws FigureNotExistException;
}
