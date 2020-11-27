package com.epam.jwd.strategy;

public interface GeometricCalcStrategy<T> {
    double calculatePerimeter(T figure);
    double calculateSquare(T figure);
}
