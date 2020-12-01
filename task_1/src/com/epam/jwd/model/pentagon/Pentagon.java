package com.epam.jwd.model.pentagon;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.PentagonCalculator;

import java.util.List;

public class Pentagon extends Figure {
    PentagonCalculator strategy;

    Pentagon(List<Point> points) {
        super(points);
    }

    double calculateArea() {
        return strategy.calculateArea(points);
    }

    double calculatePerimeter() {
        return strategy.calculatePerimeter(points);
    }
}
