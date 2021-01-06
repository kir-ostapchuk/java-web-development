package com.epam.jwd.task.app;

import com.epam.jwd.task.context.impl.LineApplicationContext;
import com.epam.jwd.task.context.impl.SquareApplicationContext;
import com.epam.jwd.task.crud.FigureCrud;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.factory.impl.line.Line;
import com.epam.jwd.task.model.factory.impl.line.LineFactory;
import com.epam.jwd.task.model.factory.impl.square.Square;
import com.epam.jwd.task.model.factory.impl.square.SquareFactory;
import com.epam.jwd.task.specification.Specification;
import com.epam.jwd.task.specification.SquareSpecification;
import com.epam.jwd.task.storage.LineStorage;
import com.epam.jwd.task.storage.SquareStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

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
