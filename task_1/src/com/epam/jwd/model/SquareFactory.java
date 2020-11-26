package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SquareFactory implements FigureFactory<Square> {

    private static final Logger LOGGER = LogManager.getLogger(SquareFactory.class);

    @Override
    public Square createFigure(List<Point> points) {
        boolean isCreatable = canCreateSquare(points);
        if (!isCreatable) {
            LOGGER.error("Cannot create a square");
        }
        return new Square(points.get(0), points.get(1), points.get(2), points.get(3));
    }

    boolean canCreateSquare(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);

        boolean result1 = compressPoints.size() == points.size();

        return result1;
    }
}
