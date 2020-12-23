package com.epam.jwd.task.view.factories;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.view.Figure;
import com.epam.jwd.task.view.Point;
import com.epam.jwd.task.view.Color;

import java.util.List;

@FunctionalInterface
public interface FigureFactory<T extends Figure> {
    T createFigure(List<Point> points, String name, Color color) throws FigureException;
}
