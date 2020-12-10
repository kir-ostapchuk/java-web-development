package com.epam.jwd.calculations;

import com.epam.jwd.model.Figure;

@FunctionalInterface
public interface AreaCalculator<T extends Figure> {
    double calculateArea(T figure);
}