package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

import java.util.List;

@FunctionalInterface
public interface AreaCalculator {
    double calculateArea(List<Point> points);
}