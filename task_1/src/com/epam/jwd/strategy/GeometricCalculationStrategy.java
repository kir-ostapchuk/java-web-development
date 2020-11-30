package com.epam.jwd.strategy;

public interface GeometricCalculationStrategy<T> {
    double calculatePerimeter(T figure);
    double calculateSquare(T figure);
}
