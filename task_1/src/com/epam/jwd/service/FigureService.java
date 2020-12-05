package com.epam.jwd.service;

import com.epam.jwd.model.Figure;

public interface FigureService<T extends Figure> {
    double calculateArea(T figure);

    double calculatePerimeter(T figure);
}
