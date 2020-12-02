package com.epam.jwd.strategy;

import com.epam.jwd.model.MultiAngleFigure;

@FunctionalInterface
public interface PerimeterCalculator<T extends MultiAngleFigure> {
    double calculatePerimeter(T multiAngleFigure);
}
