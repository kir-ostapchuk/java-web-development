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
// 1.
        Point[] points = new Point[4];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(i, i + 7);
        }
// 2.
        Line[] lines = new Line[2];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Line(
                    new Point(i, i + 7),
                    new Point(i + 2, i + 9));
        }
// 3.
        Triangle[] triangles = new Triangle[2];
        for (int i = 0; i < triangles.length; i++) {
            triangles[i] = new Triangle(
                    new Point(i, i + 7),
                    new Point(i + 1, i + 12),
                    new Point(i + 2, i + 9));
        }
// 4.
        Square[] squares = new Square[1];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square(
                    new Point(i + 7, i),
                    new Point(i, i),
                    new Point(i, i + 3),
                    new Point(i + 7, i + 3));
        }
// 5.

// 6.
// 6.1.
        for (Line line : lines) {
            LOGGER.info(line.toString());
        }

        if(triangles.length > 0) {
            for (Triangle triangle : triangles) {
                LOGGER.info(triangle.toString());
            }
        }
        else {
            //LOGGER.error(triangle);
        }
    }
}
