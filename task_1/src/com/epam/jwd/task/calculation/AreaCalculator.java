package com.epam.jwd.task.calculation;

import com.epam.jwd.task.model.Figure;

@FunctionalInterface
public interface AreaCalculator<T extends Figure> {

    double calculateArea(T figure);
}