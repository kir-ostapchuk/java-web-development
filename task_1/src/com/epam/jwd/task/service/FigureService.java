package com.epam.jwd.task.service;

import com.epam.jwd.task.model.Figure;

public interface FigureService<T extends Figure> {
    double calculateArea(T figure);

    double calculatePerimeter(T figure);
}
