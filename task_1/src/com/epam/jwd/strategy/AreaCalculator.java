package com.epam.jwd.strategy;

import com.epam.jwd.model.MultiAngleFigure;

@FunctionalInterface
public interface AreaCalculator<T extends MultiAngleFigure> {
    double calculateArea(T multiAngleFigure);
}