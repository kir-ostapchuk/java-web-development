package com.epam.jwd.app;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Line;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.model.Square;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Point[] points = createPoints(4);
        Line[] lines = createLines(2);
        Triangle[] triangles = createTriangles(2);
        Square[] squares = createSquares(1);

    }

    private static Point[] createPoints(int length) {
        Point[] points = new Point[length];
        for (int i = 0; i < length; i++) {
            points[i] = new Point(i, i + 7);
        }

        return points;
    }

    private static Line[] createLines(int length) {
        Line[] lines = new Line[length];
        for (int i = 0; i < length; i++) {
            lines[i] = new Line(
                    new Point(i, i + 7),
                    new Point(i + 2, i + 9));
        }

        return lines;
    }

    private static Triangle[] createTriangles(int length) {
        Triangle[] triangles = new Triangle[length];
        for (int i = 0; i < length; i++) {
            triangles[i] = new Triangle(
                    new Point(i, i + 7),
                    new Point(i + 1, i + 12),
                    new Point(i + 2, i + 9));
        }

        return triangles;
    }

    private static Square[] createSquares(int length) {
        Square[] squares = new Square[length];
        for (int i = 0; i < length; i++) {
            squares[i] = new Square(
                    new Point(i + 7, i),
                    new Point(i, i),
                    new Point(i, i + 3),
                    new Point(i + 7, i + 3));
        }

        return squares;
    }
}
