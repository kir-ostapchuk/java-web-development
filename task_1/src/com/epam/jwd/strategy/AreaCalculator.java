package com.epam.jwd.strategy;

@FunctionalInterface
public interface AreaCalculator<T> {
    double calculateArea(T figure);
}