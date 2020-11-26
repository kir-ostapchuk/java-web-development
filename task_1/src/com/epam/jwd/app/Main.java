package com.epam.jwd.app;

import com.epam.jwd.model.LineFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SquareFactory;
import com.epam.jwd.model.TriangleFactory;
import com.epam.jwd.model.Line;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.model.Square;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Point[] points = createPoints(4);
        Line[] lines = createLines(2);
        Triangle[] triangles = createTriangles(2);
        Square[] squares = createSquares(1);

    }

    private static Point[] createPoints(int length) {
        Point[] points = new Point[length];
        for (int i = 0; i < length; i++) {
            points[i] = new Point(i, i + 9);
        }

        return points;
    }

    private static Line[] createLines(int length) {
        LineFactory lineFactory = new LineFactory();

        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 2));
        points.add(new Point(2, 2));

        Line[] lines = new Line[length];
        for (int i = 0; i < length; i++) {
            lines[i] = lineFactory.createFigure(points);
        }
        return lines;
    }

    private static Triangle[] createTriangles(int length) {
        TriangleFactory triangleFactory = new TriangleFactory();

        List<Point> points = new ArrayList<>();
        points.add(new Point(2, 2));
        points.add(new Point(2, 2));
        points.add(new Point(3, 2));

        Triangle[] triangles = new Triangle[length];
        for (int i = 0; i < length; i++) {
            triangles[i] = triangleFactory.createFigure(points);
        }
        return triangles;
    }

    private static Square[] createSquares(int length) {
        SquareFactory squareFactory = new SquareFactory();

        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 2));
        points.add(new Point(2, 2));
        points.add(new Point(3, 2));
        points.add(new Point(4, 2));

        Square[] squares = new Square[length];
        for (int i = 0; i < length; i++) {
            squares[i] = squareFactory.createFigure(points);
        }
        return squares;
    }

}
