package com.epam.jwd.task.preprocessors.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.view.Point;
import com.epam.jwd.task.preprocessors.ExistencePreProcessor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SquareExistencePreProcessor implements ExistencePreProcessor {

    @Override
    public void preProcess(List<Point> points) throws FigureException {
        Set<Point> compressPoints = new HashSet<>(points);

        if (compressPoints.size() != points.size()) {
            throw new FigureNotExistException("Square: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + ", " +
                    points.get(3).toString() + " was NOT created. There are equal points");
        }

        if (!isSquare(points)){
            throw new FigureNotExistException("Square: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + ", " +
                    points.get(3).toString() + " was NOT created");
        }
    }

    private boolean isSquare(List<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        Point p4 = points.get(3);

        int d2 = Point.squareDis(p1, p2);
        int d3 = Point.squareDis(p1, p3);
        int d4 = Point.squareDis(p1, p4);

        if (d2 == 0 || d3 == 0 || d4 == 0) {
            return false;
        }
        if (d2 == d3 && 2 * d2 == d4 &&
                (2 * Point.squareDis(p2, p4) == Point.squareDis(p2, p3))) {
            return true;
        }
        if (d3 == d4 && 2 * d3 == d2 &&
                (2 * Point.squareDis(p3, p2) == Point.squareDis(p3, p4))) {
            return true;
        }
        if (d2 == d4 && 2 * d2 == d3 &&
                (2 * Point.squareDis(p2, p3) == Point.squareDis(p2, p4))) {
            return true;
        }
        return false;
    }

}
