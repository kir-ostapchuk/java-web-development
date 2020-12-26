package com.epam.jwd.task.app;

import com.epam.jwd.task.context.impl.LineApplicationContext;
import com.epam.jwd.task.context.impl.SquareApplicationContext;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factory.impl.line.Line;
import com.epam.jwd.task.model.factory.impl.line.LineFactory;
import com.epam.jwd.task.model.factory.impl.square.Square;
import com.epam.jwd.task.model.factory.impl.square.SquareFactory;
import com.epam.jwd.task.crud.FigureCrud;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.specification.Specification;
import com.epam.jwd.task.specification.SquareSpecification;
import com.epam.jwd.task.storage.LineStorage;
import com.epam.jwd.task.storage.SquareStorage;
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
            FigureCrud<Square> squareFigureCrud = new FigureCrud<>(new SquareApplicationContext(),
                    SquareFactory.INSTANCE,
                    new SquareStorage());

            squareFigureCrud.create(Arrays.asList(new Point(1, 2), new Point(-1, 2), new Point(-1, 0), new Point(1, 0)),
                    "Test1",
                    Color.BLUE);
            squareFigureCrud.create(Arrays.asList(new Point(1, 2), new Point(-1, 2), new Point(-1, 0), new Point(1, 0)),
                    "Test2",
                    Color.BLACK);
            squareFigureCrud.create(Arrays.asList(new Point(1, 2), new Point(-1, 2), new Point(-1, 0), new Point(1, 0)),
                    "Test3",
                    Color.BROWN);
            Specification specification = SquareSpecification.builder()
                    .whereColor(Color.BROWN)
                    .build();

            FigureCrud<Line> lineFigureCrud = new FigureCrud<>(new LineApplicationContext(),
                    LineFactory.INSTANCE,
                    new LineStorage());

            Line line = lineFigureCrud.create(Collections.singletonList(new Point(1, 2)),
                    "Test1",
                    Color.BLUE);
        } catch (FigureException exception) {
            LOGGER.error(exception.getMessage());
        }
    }
}
