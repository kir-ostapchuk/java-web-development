package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.epam.jwd.model.Point.squareDis;

public class SquareFactory implements FigureFactory<Square> {

    private static final Logger LOGGER = LogManager.getLogger(SquareFactory.class);

    @Override
    public Square createFigure(List<Point> points) {
        boolean isCreatable = canCreateSquare(points);
        if (!isCreatable) {
            throw new IllegalArgumentException("Square: " +
                    points.get(0).toString() + ", " +
                    points.get(1).toString() + ", " +
                    points.get(2).toString() + " was NOT created");

        }
        LOGGER.info("Square: " +
                points.get(0).toString() + ", " +
                points.get(1).toString() + ", " +
                points.get(2).toString() + " was created");

        return new Square(points.get(0), points.get(1), points.get(2), points.get(3));
    }

    private boolean canCreateSquare(List<Point> points) {
        Set<Point> compressPoints = new HashSet(points);
        if (compressPoints.size() != points.size()) {
            return false;
        }

        return isSquare(points.get(0), points.get(1), points.get(2), points.get(3));
    }

    private boolean isSquare(Point p1, Point p2, Point p3, Point p4) {
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
