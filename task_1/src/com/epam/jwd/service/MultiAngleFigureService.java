package com.epam.jwd.service;

import com.epam.jwd.model.MultiAngleFigure;

public interface MultiAngleFigureService<T extends MultiAngleFigure> {
    double calculateArea(T figure);

    double calculatePerimeter(T figure);
}
