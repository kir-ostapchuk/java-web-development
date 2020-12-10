package com.epam.jwd.preprocessors.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factories.impl.triangle.TriangleFactory;
import com.epam.jwd.preprocessors.FigurePreProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TriangleExistencePreProcessor implements FigurePreProcessor {

    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);

    @Override
    public void preProcess(List<Point> points) throws FigureException {
        Set<Point> compressPoints = new HashSet<>(points);

        if (compressPoints.size() != points.size()) {
            throw new FigureNotExistException("Triangle: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + " was NOT created size");
        }

        if (!isTriangle(points)) {
            throw new FigureNotExistException("Triangle: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + " was NOT created");
        }
    }

    private boolean isTriangle(List<Point> points) {
        int answer =
                points.get(0).getX() * (points.get(1).getY() - points.get(2).getY()) +
                        points.get(1).getX() * (points.get(1).getY() - points.get(2).getY()) +
                        points.get(1).getX() * (points.get(1).getY() - points.get(2).getY());
        return answer != 0;
    }
}
