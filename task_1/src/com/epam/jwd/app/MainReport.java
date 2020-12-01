package com.epam.jwd.app;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.line.Line;
import com.epam.jwd.model.line.LineFactory;
import com.epam.jwd.model.pentagon.Pentagon;
import com.epam.jwd.model.pentagon.PentagonFactory;
import com.epam.jwd.model.square.Square;
import com.epam.jwd.model.square.SquareFactory;
import com.epam.jwd.model.triangle.Triangle;
import com.epam.jwd.model.triangle.TriangleFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainReport {
    private static final Logger LOGGER = LogManager.getLogger(MainReport.class);

    public static List<Point> createPoints(List<Integer> xCoordinates, List<Integer> yCoordinates) {

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < xCoordinates.size(); i++) {
            points.add(new Point(xCoordinates.get(i), yCoordinates.get(i)));
        }
        return points;
    }

    public static List<Line> createLines(List<Integer> xCoordinates, List<Integer> yCoordinates) {
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

    public static List<Triangle> createTriangles(List<Integer> xCoordinates, List<Integer> yCoordinates) {
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

    public static List<Square> createSquares(List<Integer> xCoordinates, List<Integer> yCoordinates) {
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

    public static List<Pentagon> createPentagons(List<Integer> xCoordinates, List<Integer> yCoordinates) {
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
