package com.epam.jwd.app;

import com.epam.jwd.model.pentagon.Pentagon;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.line.Line;
import com.epam.jwd.model.triangle.Triangle;
import com.epam.jwd.model.square.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static final List<Integer> xPointCoordinates = Arrays.asList(1, 2, 3, 4);
    private static final List<Integer> yPointCoordinates = Arrays.asList(4, 3, 2, 1);

    private static final List<Integer> xLineCoordinates = Arrays.asList(-1, -2, -3, -4);
    private static final List<Integer> yLineCoordinates = Arrays.asList(-4, -3, -2, -1);

    private static final List<Integer> xTriangleCoordinates = Arrays.asList(-4, 3, -2, -1, 8, 9);
    private static final List<Integer> yTriangleCoordinates = Arrays.asList(-4, -3, 2, -1, -8, -9);

    private static final List<Integer> xSquareCoordinates = Arrays.asList(1, 0, 1, 0);
    private static final List<Integer> ySquareCoordinates = Arrays.asList(0, 1, 1, 0);

    private static final List<Integer> xPentagonCoordinates = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> yPentagonCoordinates = Arrays.asList(4, 3, 2, 1, 6);

    public static void main(String[] args) {
        try {
            List<Point> points = MainUtility.createPoints(xPointCoordinates, yPointCoordinates);
            List<Line> lines = MainUtility.createLines(xLineCoordinates, yLineCoordinates);
            List<Triangle> triangles = MainUtility.createTriangles(xTriangleCoordinates, yTriangleCoordinates);
            List<Square> squares = MainUtility.createSquares(xSquareCoordinates, ySquareCoordinates);
            List<Pentagon> pentagons = MainUtility.createPentagons(xPentagonCoordinates, yPentagonCoordinates);
        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception.getMessage());
        }
    }
}
