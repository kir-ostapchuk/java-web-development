package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;

@FunctionalInterface
public interface PerimeterCalculator<T extends Figure> {
    double calculatePerimeter(T figure);
}
