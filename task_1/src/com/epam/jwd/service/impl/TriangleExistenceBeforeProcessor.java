package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.triangle.TriangleFactory;
import com.epam.jwd.service.FigureBeforeProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TriangleExistenceBeforeProcessor implements FigureBeforeProcessor {

    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);

    @Override
    public boolean process(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);

        if (compressPoints.size() == points.size()) {
            int answer =
                    points.get(0).getX() * (points.get(1).getY() - points.get(2).getY()) +
                            points.get(1).getX() * (points.get(1).getY() - points.get(2).getY()) +
                            points.get(1).getX() * (points.get(1).getY() - points.get(2).getY());
            return answer != 0;
        } else {
            return false;
        }
    }
}
