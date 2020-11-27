// TODO:
// 1. create Figure to keep points amount (ex. for triangle = 3, for line= 2)
// 2. hexagon

package com.epam.jwd.app;

import com.epam.jwd.model.LineFactory;
import com.epam.jwd.model.Pentagon;
import com.epam.jwd.model.PentagonFactory;
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

        final List<Integer> xSquareCoordinates = Arrays.asList(1, 0, 1, 0);
        final List<Integer> ySquareCoordinates = Arrays.asList(0, 1, 1, 0);

        final List<Integer> xPentagonCoordinates = Arrays.asList(1, 2, 3, 4, 5, 5, 6);
        final List<Integer> yPentagonCoordinates = Arrays.asList(4, 3, 2, 1, 6, 7, 8);

        try {
            List<Point> points = createPoints(xPointCoordinates, yPointCoordinates);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception.getMessage());
        }
        try {
            List<Line> lines = createLines(xLineCoordinates, yLineCoordinates);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception.getMessage());
        }
        try {
            List<Triangle> triangles = createTriangles(xTriangleCoordinates, yTriangleCoordinates);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception.getMessage());
        }
        try {
            List<Square> squares = createSquares(xSquareCoordinates, ySquareCoordinates);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception.getMessage());
        }
        try {
            List<Pentagon> pentagons = createPentagons(xPentagonCoordinates, yPentagonCoordinates);
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

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> twoPoints;
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i <= allPoints.size() - 2; i += 2) {
            twoPoints = allPoints.subList(i, i + 2);
            lines.add(lineFactory.createFigure(twoPoints));
        }
        return lines;
    }

    private static List<Triangle> createTriangles(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        TriangleFactory triangleFactory = new TriangleFactory();

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> threePoints;
        List<Triangle> triangles = new ArrayList<>();

        for (int i = 0; i <= allPoints.size() - 3; i += 3) {
            threePoints = allPoints.subList(i, i + 3);
            triangles.add(triangleFactory.createFigure(threePoints));
        }

        return triangles;
    }

    private static List<Square> createSquares(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        SquareFactory squareFactory = new SquareFactory();

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> fourPoints;
        List<Square> squares = new ArrayList<>();

        for (int i = 0; i <= allPoints.size() - 4; i += 4) {
            fourPoints = allPoints.subList(i, i + 4);
            squares.add(squareFactory.createFigure(fourPoints));
        }
        return squares;
    }

    private static List<Pentagon> createPentagons(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        PentagonFactory pentagonFactory = new PentagonFactory();

        List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
        List<Point> fivePoints;
        List<Pentagon> pentagons = new ArrayList<>();

        for (int i = 0; i <= allPoints.size() - 5; i += 5) {
            fivePoints = allPoints.subList(i, i + 5);
            pentagons.add(pentagonFactory.createFigure(fivePoints));
        }
        return pentagons;
    }

}
