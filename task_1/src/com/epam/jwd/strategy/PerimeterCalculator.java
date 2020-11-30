package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

import java.util.List;

public interface PerimeterCalculator {
    double calculatePerimeter(List<Point> points);
}
