package com.epam.jwd.task.preprocessor.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.preprocessor.ExistencePreProcessor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TriangleExistencePreProcessor implements ExistencePreProcessor {

    @Override
    public void preProcess(List<Point> points) throws FigureException {
        Set<Point> compressPoints = new HashSet<>(points);
        if (compressPoints.size() != points.size()) {
            throw new FigureNotExistException("Triangle: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + " was NOT created. There are equal points");
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
        return answer >= 0;
    }
}
