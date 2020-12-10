package com.epam.jwd.calculations;

import com.epam.jwd.model.Figure;

@FunctionalInterface
public interface PerimeterCalculator<T extends Figure> {
    double calculatePerimeter(T figure);
}
