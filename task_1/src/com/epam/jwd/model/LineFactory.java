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
        boolean isCreatable = canCreateLine(points);
        if (!isCreatable) {
            throw new IllegalArgumentException("Line: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + " was NOT created");
        }
        LOGGER.info("Line: " +
                points.get(0).toString() + ", " +
                points.get(1).toString() + " was created");
        return new Line(points.get(0), points.get(1));
    }

    private boolean canCreateLine(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);

        return compressPoints.size() == points.size();
    }
}
