package com.epam.jwd.app;

import com.epam.jwd.model.LineFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SquareFactory;
import com.epam.jwd.model.TriangleFactory;
import com.epam.jwd.model.Line;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.model.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        final List<Integer> xPointCoordinates = Arrays.asList(1, 2, 3, 4);
        final List<Integer> yPointCoordinates = Arrays.asList(4, 3, 2, 1);

        final List<Integer> xLineCoordinates = Arrays.asList(-1, -2, -3, -4);
        final List<Integer> yLineCoordinates = Arrays.asList(-4, -3, -2, -1);

        final List<Integer> xTriangleCoordinates = Arrays.asList(-4, 3, -2, -1, 8, 9);
        final List<Integer> yTriangleCoordinates = Arrays.asList(-4, -3, 2, -1, -8, -9);

        final List<Integer> xSquareCoordinates = Arrays.asList(-4, -3, -2, -1);
        final List<Integer> ySquareCoordinates = Arrays.asList(-4, -3, -2, -1);

        try {
            List<Point> points = createPoints(xPointCoordinates, yPointCoordinates);
            List<Line> lines = createLines(xLineCoordinates, yLineCoordinates);
            List<Triangle> triangles = createTriangles(xTriangleCoordinates, yTriangleCoordinates);
            List<Square> squares = createSquares(xSquareCoordinates, ySquareCoordinates);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception.getMessage());
        }
    }

    private static List<Point> createPoints(List<Integer> xCoordinates, List<Integer> yCoordinates) {

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < xCoordinates.size(); i++) {
            points.add(new Point(xCoordinates.get(i), yCoordinates.get(i)));
        }
        return points;
    }

    private static List<Line> createLines(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        LineFactory lineFactory = new LineFactory();

        List<Point> points = createPoints(xCoordinates, yCoordinates);
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < xCoordinates.size(); i++) {
            lines.add(lineFactory.createFigure(points));
        }
        return lines;
    }

    private static List<Triangle> createTriangles(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        TriangleFactory triangleFactory = new TriangleFactory();

        List<Point> points = createPoints(xCoordinates, yCoordinates);
        List<Triangle> triangles = new ArrayList<>();

        for (int i = 0; i < xCoordinates.size(); i++) {
            triangles.add(triangleFactory.createFigure(points));
        }
        return triangles;
    }

    private static List<Square> createSquares(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        SquareFactory squareFactory = new SquareFactory();

        List<Point> points = createPoints(xCoordinates, yCoordinates);
        List<Square> squares = new ArrayList<>();

        for (int i = 0; i < xCoordinates.size(); i++) {
            squares.add(squareFactory.createFigure(points));
        }
        return squares;
    }

}
