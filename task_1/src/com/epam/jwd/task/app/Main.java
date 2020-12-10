package com.epam.jwd.task.app;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.factories.impl.line.Line;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factories.impl.square.Square;
import com.epam.jwd.task.model.factories.impl.subfigures.MultiAngleFigure;
import com.epam.jwd.task.model.factories.impl.triangle.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static final List<Integer> X_POINT_COORDINATES = Arrays.asList(1, 1, 3, 4);
    private static final List<Integer> Y_POINT_COORDINATES = Arrays.asList(4, 2, 2, 1);

    private static final List<Integer> X_LINE_COORDINATES = Arrays.asList(-1, -1, -3, -4);
    private static final List<Integer> Y_LINE_COORDINATES = Arrays.asList(-4, -3, -2, -1);

    private static final List<Integer> X_TRIANGLE_COORDINATES = Arrays.asList(-4, 3, -2, -1, 8, 9);
    private static final List<Integer> Y_TRIANGLE_COORDINATES = Arrays.asList(-2, -3, 2, -1, -8, -9);

    private static final List<Integer> X_SQUARE_COORDINATES = Arrays.asList(1, 0, 1, 0);
    private static final List<Integer> Y_SQUARE_COORDINATES = Arrays.asList(1, 1, 1, 0);

    private static final List<Integer> X_PENTAGON_COORDINATES = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> Y_PENTAGON_COORDINATES = Arrays.asList(4, 3, 2, 1, 6);

    public static void main(String[] args) {
        try {
            List<Point> points = MainService.createPoints(X_POINT_COORDINATES, Y_POINT_COORDINATES);
            List<Line> lines = MainService.createLines(X_LINE_COORDINATES, Y_LINE_COORDINATES);
            List<Triangle> triangles = MainService.createTriangles(X_TRIANGLE_COORDINATES, Y_TRIANGLE_COORDINATES);
            List<MultiAngleFigure> multiAngleFigures =
                   MainService.createMultiAngleFigures(X_PENTAGON_COORDINATES, Y_PENTAGON_COORDINATES);
            List<Square> squares = MainService.createSquares(X_SQUARE_COORDINATES, Y_SQUARE_COORDINATES);
        } catch (FigureException exception) {
            LOGGER.error(exception.getMessage());
        }

    }
}
