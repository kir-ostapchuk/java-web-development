package com.epam.jwd.app;

import com.epam.jwd.model.LineFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.PointFactory;
import com.epam.jwd.model.SquareFactory;
import com.epam.jwd.model.TriangleFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
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

        logPoints(points);
        logLines(lines);
        logTriangle(triangles);
        logSquares(squares);
    }

    private static Point[] createPoints(int length) {
        PointFactory pointFactory = new PointFactory();

        Point[] points = new Point[length];
        for (int i = 0; i < length; i++) {
            points[i] = pointFactory.createPoint(i, i + 9);
        }

        return points;
    }

    private static Line[] createLines(int length) {
        LineFactory lineFactory = new LineFactory();

        Line[] lines = new Line[length];
        for (int i = 0; i < length; i++) {
            lines[i] = lineFactory.createLine(i, i + 2, i + 3, i - 7);
        }
        return lines;
    }

    private static Triangle[] createTriangles(int length) {
        TriangleFactory triangleFactory = new TriangleFactory();

        Triangle[] triangles = new Triangle[length];
        for (int i = 0; i < length; i++) {
            triangles[i] = triangleFactory.createTriangle(
                    i, i + 1, i + 2, i - 3, i + 9, i + 5
            );
        }
        return triangles;
    }

    private static Square[] createSquares(int length) {
        SquareFactory squareFactory = new SquareFactory();

        Square[] squares = new Square[length];
        for (int i = 0; i < length; i++) {
            squares[i] = squareFactory.createSquare(
                    i, i + 1, i + 2, i - 3, i + 9, i + 5, i + 9, i - 2
            );
        }
        return squares;
    }

    private static void logPoints(Point[] points) {
        int i = 0;
        do {
            LOGGER.info(points[i].toString());
            i++;
        }
        while (i < points.length);
    }

    private static void logLines(Line[] lines) {
        for (Line line : lines) {
            if (line.defaultValidate()) {
                LOGGER.info(line.toString());
            } else {
                LOGGER.error("Object " + line.toString() + " isn't a line");
            }
        }
    }

    private static void logTriangle(Triangle[] triangles) {
        for (Triangle triangle : triangles) {
            if (!triangle.defaultValidate()) {
                LOGGER.error("Object " + triangle.toString() + " isn't a triangle");
            } else if (!triangle.validate()) {
                LOGGER.error("Cannot exist " + triangle.toString());
            } else {
                LOGGER.info(triangle.toString());
            }
        }
    }

    private static void logSquares(Square[] squares) {
        for (Square square : squares) {
            if (!square.defaultValidate()) {
                LOGGER.error("Object " + square.toString() + " isn't a square");
            } else if (!square.validate()) {
                LOGGER.error("Cannot exist " + square.toString());
            } else {
                LOGGER.info(square.toString());
            }
        }
    }

}
