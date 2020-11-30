// TODO:
// 1. create Figure to keep points amount (ex. for triangle = 3, for line= 2)
// 2. hexagon
// 3. functional interfaces

package com.epam.jwd.app;

import com.epam.jwd.model.line.LineFactory;
import com.epam.jwd.model.pentagon.Pentagon;
import com.epam.jwd.model.pentagon.PentagonFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.square.SquareFactory;
import com.epam.jwd.model.triangle.TriangleFactory;
import com.epam.jwd.model.line.Line;
import com.epam.jwd.model.triangle.Triangle;
import com.epam.jwd.model.square.Square;
import com.epam.jwd.strategy.SquareStrategy;
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

        final List<Integer> xPentagonCoordinates = Arrays.asList(1, 2, 3, 4, 5);
        final List<Integer> yPentagonCoordinates = Arrays.asList(4, 3, 2, 1, 6);

        List<Point> points = createPoints(xPointCoordinates, yPointCoordinates);
        List<Line> lines = createLines(xLineCoordinates, yLineCoordinates);
        List<Triangle> triangles = createTriangles(xTriangleCoordinates, yTriangleCoordinates);
        List<Square> squares = createSquares(xSquareCoordinates, ySquareCoordinates);
        List<Pentagon> pentagons = createPentagons(xPentagonCoordinates, yPentagonCoordinates);
    }


    private static List<Point> createPoints(List<Integer> xCoordinates, List<Integer> yCoordinates) {

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < xCoordinates.size(); i++) {
            points.add(new Point(xCoordinates.get(i), yCoordinates.get(i)));
        }
        return points;
    }

    private static List<Line> createLines(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        List<Line> lines = new ArrayList<>();
        try {
            LineFactory lineFactory = new LineFactory();

            List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
            List<Point> twoPoints;

            for (int i = 0; i <= allPoints.size() - 2; i += 2) {
                twoPoints = allPoints.subList(i, i + 2);
                lines.add(lineFactory.createFigure(twoPoints));
            }
        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception.getMessage());
        }
        return lines;
    }

    private static List<Triangle> createTriangles(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        List<Triangle> triangles = new ArrayList<>();
        try {
            TriangleFactory triangleFactory = new TriangleFactory();

            List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
            List<Point> threePoints;

            for (int i = 0; i <= allPoints.size() - 3; i += 3) {
                threePoints = allPoints.subList(i, i + 3);
                triangles.add(triangleFactory.createFigure(threePoints));
            }

        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception.getMessage());
        }
        return triangles;
    }

    private static List<Square> createSquares(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        List<Square> squares = new ArrayList<>();
        try {
            SquareFactory squareFactory = new SquareFactory();

            List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
            List<Point> fourPoints;

            for (int i = 0; i <= allPoints.size() - 4; i += 4) {
                fourPoints = allPoints.subList(i, i + 4);
                squares.add(squareFactory.createFigure(fourPoints));
            }
        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception.getMessage());
        }
        return squares;
    }

    private static List<Pentagon> createPentagons(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        List<Pentagon> pentagons = new ArrayList<>();
        try {
            PentagonFactory pentagonFactory = new PentagonFactory();

            List<Point> allPoints = createPoints(xCoordinates, yCoordinates);
            List<Point> fivePoints;

            for (int i = 0; i <= allPoints.size() - 5; i += 5) {
                fivePoints = allPoints.subList(i, i + 5);
                pentagons.add(pentagonFactory.createFigure(fivePoints));
            }
        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception.getMessage());
        }
        return pentagons;
    }

}
