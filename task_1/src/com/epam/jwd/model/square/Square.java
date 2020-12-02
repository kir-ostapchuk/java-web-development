package com.epam.jwd.model.square;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.SquareCalculator;

import java.util.List;

public class Square extends Figure {
    private SquareCalculator strategy;

    Square(List<Point> points) {
        super(points);
    }

    double calculateArea() {
        return strategy.calculateArea(points);
    }

    double calculatePerimeter() {
        return strategy.calculatePerimeter(points);
    }
}
