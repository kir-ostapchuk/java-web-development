package com.epam.jwd.task.app;

import com.epam.jwd.task.calculations.impl.TriangleCalculator;
import com.epam.jwd.task.context.ApplicationContext;
import com.epam.jwd.task.context.impl.LineApplicationContext;
import com.epam.jwd.task.context.impl.TriangleApplicationContext;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factories.impl.line.Line;
import com.epam.jwd.task.model.factories.impl.line.LineFactory;
import com.epam.jwd.task.model.factories.impl.triangle.Triangle;
import com.epam.jwd.task.model.factories.impl.triangle.TriangleFactory;
import com.epam.jwd.task.service.FigureCrud;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.specification.Specification;
import com.epam.jwd.task.storage.impl.LineStorage;
import com.epam.jwd.task.storage.impl.TriangleStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static final List<Integer> X_POINT_COORDINATES = Arrays.asList(-1, -1, -10, -10);
    private static final List<Integer> Y_POINT_COORDINATES = Arrays.asList(-4, -3, -40, -30);

    private static final List<Integer> X_LINE_COORDINATES = Arrays.asList(-1, -1, -1, -1, -3, -2);
    private static final List<Integer> Y_LINE_COORDINATES = Arrays.asList(-4, -3, -4, -3, -3, -3);

    private static final List<Integer> X_TRIANGLE_COORDINATES = Arrays.asList(-4, 3, -2, -1, 8, 9);
    private static final List<Integer> Y_TRIANGLE_COORDINATES = Arrays.asList(-2, -3, 2, -1, -8, -9);

    private static final List<Integer> X_SQUARE_COORDINATES = Arrays.asList(1, 0, 1, 0);
    private static final List<Integer> Y_SQUARE_COORDINATES = Arrays.asList(1, 1, 1, 0);

    private static final List<Integer> X_PENTAGON_COORDINATES = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> Y_PENTAGON_COORDINATES = Arrays.asList(4, 3, 2, 1, 6);

    public static void main(String[] args) {
        try {
            List<Point> points = MainService.createPoints(X_POINT_COORDINATES, Y_POINT_COORDINATES);
            String name = "Spec";
            FigureCrud<Line> lineFigureCrud = new FigureCrud<>(new LineApplicationContext(), LineFactory.INSTANCE, new LineStorage());
            List<Line> lines = MainService.createLines(X_LINE_COORDINATES, Y_LINE_COORDINATES, name, Color.BLACK);
            List<Line> line = lineFigureCrud.find(lineFigureCrud.create(points, "Special", Color.GREEN));


//            lineFigureCrud.create(null, "null", Color.BLUE);
            lineFigureCrud.create(Arrays.asList(new Point(2, 8), new Point(2, 2)), "Tqweest", Color.BROWN);
            lineFigureCrud.create(Arrays.asList(new Point(3, 9), new Point(3, 3)), "qweqTest", Color.BLACK);
            lineFigureCrud.create(Arrays.asList(new Point(4, 5), new Point(4, 4)), "Test", Color.WHITE);
            lineFigureCrud.create(Arrays.asList(new Point(5, -2), new Point(100, 100)), "Testqwerty", Color.GREEN);

            FigureCrud<Triangle> triangleFigureCrud = new FigureCrud<>(
                    new TriangleApplicationContext(),
                    TriangleFactory.INSTANCE,
                    new TriangleStorage());

            triangleFigureCrud.create(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(2, 1)), "1Testweqe", Color.RED);
            triangleFigureCrud.create(Arrays.asList(new Point(10, 10), new Point(20, 20), new Point(20, 10)), "2Testweqe", Color.WHITE);
            triangleFigureCrud.create(Arrays.asList(new Point(-1, 1), new Point(2, -2), new Point(8, -5)), "3Testweqe", Color.BLACK);
            triangleFigureCrud.create(Arrays.asList(new Point(1, -1), new Point(0, 0), new Point(1, 0)), "Testweqe", Color.GREEN);
            triangleFigureCrud.create(Arrays.asList(new Point(1, 1), new Point(-2, -2), new Point(3, 1)), "Testweqe", Color.BLACK);

            Specification specification = Specification.builder()
                    .whereColor(Color.WHITE)
//                    .whereNameStartsWith("Test")
//                    .whereName("Test")
                    .whereAreaGreater(10)
                    .build();

            System.out.println(lineFigureCrud.findBySpecification(specification).toString());
            System.out.println(triangleFigureCrud.findBySpecification(specification));
        } catch (FigureException exception) {
            LOGGER.error(exception.getMessage());
        }
    }
}
