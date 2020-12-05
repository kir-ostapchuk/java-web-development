package com.epam.jwd.service.impl.preprocessor;

import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.epam.jwd.model.Point.squareDis;

public class SquareExistencePreProcessor implements FigurePreProcessor {
    @Override
    public boolean process(List<Point> points) {
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
