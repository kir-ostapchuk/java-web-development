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
        if (isCreatable) {
            LOGGER.info("Triangle: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + " was created");
            return new Triangle(points.get(0), points.get(1), points.get(2));
        } else {
            LOGGER.error("Triangle: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + " was NOT created");
            return null;
        }
    }

    private boolean canCreateTriangle(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);

        if (compressPoints.size() == points.size()) {
            int answer = points.get(0).getX() * (points.get(1).getY() - points.get(2).getY()) +
                    points.get(1).getX() * (points.get(1).getY() - points.get(2).getY()) +
                    points.get(1).getX() * (points.get(1).getY() - points.get(2).getY());
            return answer != 0;
        } else {
            return false;
        }
    }
}
