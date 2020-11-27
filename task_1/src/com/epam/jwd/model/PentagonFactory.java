package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PentagonFactory implements FigureFactory<Pentagon> {

    private static final Logger LOGGER = LogManager.getLogger(PentagonFactory.class);

    @Override
    public Pentagon createFigure(List<Point> points) {
        boolean isCreatable = canCreatePentagon(points);
        if (!isCreatable) {
            throw new IllegalArgumentException("Pentagon: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + ", " +
                    points.get(3).toString() + ", " +
                    points.get(4).toString() + " was NOT created");


        }
        LOGGER.info("Pentagon: " +
                points.get(0).toString() + ", " +
                points.get(1).toString() + ", " +
                points.get(2).toString() + ", " +
                points.get(3).toString() + ", " +
                points.get(4).toString() + " was created");
        return new Pentagon(points);
    }

    private boolean canCreatePentagon(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);
        return compressPoints.size() == points.size();
        // one more validation needed
    }
}
