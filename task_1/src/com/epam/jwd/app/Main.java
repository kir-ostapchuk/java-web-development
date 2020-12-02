package com.epam.jwd.app;

import com.epam.jwd.exception.FigureNotExistException;
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

    private static final List<Integer> X_POINT_COORDINATES = Arrays.asList(1, 2, 3, 4);
    private static final List<Integer> Y_POINT_COORDINATES = Arrays.asList(4, 3, 2, 1);

    private static final List<Integer> X_LINE_COORDINATES = Arrays.asList(-1, -2, -3, -4);
    private static final List<Integer> Y_LINE_COORDINATES = Arrays.asList(-4, -3, -2, -1);

    private static final List<Integer> X_TRIANGLE_COORDINATES = Arrays.asList(-4, 3, -2, -1, 8, 9);
    private static final List<Integer> Y_TRIANGLE_COORDINATES = Arrays.asList(-4, -3, 2, -1, -8, -9);

    private static final List<Integer> X_SQUARE_COORDINATES = Arrays.asList(10, 0, 1, 0);
    private static final List<Integer> Y_SQUARE_COORDINATES = Arrays.asList(0, 1, 1, 0);

    private static final List<Integer> X_PENTAGON_COORDINATES = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> Y_PENTAGON_COORDINATES = Arrays.asList(4, 3, 2, 1, 6);

    public static void main(String[] args) {
        try {
            List<Point> points = MainUtility.createPoints(X_POINT_COORDINATES, Y_POINT_COORDINATES);
            List<Line> lines = MainUtility.createLines(X_LINE_COORDINATES, Y_LINE_COORDINATES);
            List<Triangle> triangles = MainUtility.createTriangles(X_TRIANGLE_COORDINATES, Y_TRIANGLE_COORDINATES);
            List<Square> squares = MainUtility.createSquares(X_SQUARE_COORDINATES, Y_SQUARE_COORDINATES);
            List<Pentagon> pentagons = MainUtility.createPentagons(X_PENTAGON_COORDINATES, Y_PENTAGON_COORDINATES);
        } catch (FigureNotExistException exception) {
            LOGGER.error(exception.getMessage());
        }
    }
}
