package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiAngleFigureFactory implements FigureFactory<MultiAngleFigure>{
    private static final Logger LOGGER = LogManager.getLogger(SquareFactory.class);

    @Override
    public MultiAngleFigure createFigure(List<Point> points) {
        boolean isCreatable = canCreateMultiAngleFigure(points);
        if (isCreatable) {
            LOGGER.info("MultiAngleFigure with " + points.size() + " sides was created");
            return new MultiAngleFigure(points);
        } else {
            LOGGER.info("MultiAngleFigure with " + points.size() + " sides was NOT created");
            return null;
        }
    }

    private boolean canCreateMultiAngleFigure(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);
        return compressPoints.size() == points.size();
        // one more validation needed
    }
}
