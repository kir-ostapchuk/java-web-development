package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TriangleFactory implements FigureFactory<Triangle> {

    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);

    @Override
    public Triangle createFigure(List<Point> points) {
        boolean isCreatable = canCreateTriangle(points);
        if (!isCreatable) {
            LOGGER.error("Cannot create a triangle");
        }
        return new Triangle(points.get(0), points.get(1), points.get(2));
    }

    boolean canCreateTriangle(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);

        boolean result1 = compressPoints.size() == points.size();

        return result1;
    }
}
