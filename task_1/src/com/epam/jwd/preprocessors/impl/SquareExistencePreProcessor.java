package com.epam.jwd.preprocessors.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Point;
import com.epam.jwd.preprocessors.FigurePreProcessor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.epam.jwd.model.Point.squareDis;

public class SquareExistencePreProcessor implements FigurePreProcessor {

    @Override
    public void preProcess(List<Point> points) throws FigureException {
        Set<Point> compressPoints = new HashSet<>(points);

        if (compressPoints.size() != points.size()) {
            throw new FigureNotExistException("Square: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + ", " +
                    points.get(3).toString() + " was NOT created size");
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

        int d2 = squareDis(p1, p2);
        int d3 = squareDis(p1, p3);
        int d4 = squareDis(p1, p4);

        if (d2 == 0 || d3 == 0 || d4 == 0) {
            return false;
        }
        if (d2 == d3 && 2 * d2 == d4 &&
                (2 * squareDis(p2, p4) == squareDis(p2, p3))) {
            return true;
        }
        if (d3 == d4 && 2 * d3 == d2 &&
                (2 * squareDis(p3, p2) == squareDis(p3, p4))) {
            return true;
        }
        if (d2 == d4 && 2 * d2 == d3 &&
                (2 * squareDis(p2, p3) == squareDis(p2, p4))) {
            return true;
        }
        return false;
    }

}
