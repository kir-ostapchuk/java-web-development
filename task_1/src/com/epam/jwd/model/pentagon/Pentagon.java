package com.epam.jwd.model.pentagon;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.PentagonStrategy;

import java.util.List;

public class Pentagon extends Figure {
    PentagonStrategy strategy;

    Pentagon(List<Point> points) {
        super(points);
    }

    double calculateArea() {
        return strategy.calculateArea(points);
    }
}
