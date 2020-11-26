package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineFactory implements FigureFactory<Line> {

    private static final Logger LOGGER = LogManager.getLogger(LineFactory.class);

    @Override
    public Line createFigure(List<Point> points) {
        boolean isCreatable = canCreateTriangle(points);
        if (isCreatable) {
            LOGGER.info("Line: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + " was created");
            return new Line(points.get(0), points.get(1));
        } else {
            LOGGER.error("Line: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + " was NOT created");
            return null;
        }
    }

    private boolean canCreateTriangle(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);

        return compressPoints.size() == points.size();
    }
}
