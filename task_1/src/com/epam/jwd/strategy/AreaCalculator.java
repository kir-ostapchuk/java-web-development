package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;

@FunctionalInterface
public interface AreaCalculator<T extends Figure> {
    double calculateArea(T figure);
}